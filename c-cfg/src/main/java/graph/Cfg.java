package graph;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.paypal.digraph.parser.GraphEdge;
import com.paypal.digraph.parser.GraphNode;
import com.paypal.digraph.parser.GraphParser;
import com.paypal.digraph.parser.Subgraph;

import tuinfo.IOriginalLine;
import tuinfo.OriginalLine;

public class Cfg {
	private List<EntryBlock> entryPoints;
	private Map<String, Block> blockMap;
	public Cfg(FileInputStream dot) throws IOException {
		this.entryPoints = new ArrayList<EntryBlock>();
		GraphParser parser = new GraphParser(dot);
		Map<String, GraphNode> nodes = parser.getNodes();
		Map<String, GraphEdge> edges = parser.getEdges();
		blockMap = new HashMap<String, Block>();
		for(Map.Entry<String, GraphNode> entry : nodes.entrySet()) {
			GraphNode node = entry.getValue();
			if(node.getAttributes().containsKey("label")) {
				blockMap.put(entry.getKey(), 
						parseBlock(node.getAttribute("label").toString(), entry.getKey(), node.getSubgraph()));
			}
		}
		linkBlocks(edges.keySet());
	}
	
	//TODO: Remove braces from statement sequences
	private Block parseBlock(String label, String id, Subgraph sub) {
		if(label.equals("ENTRY")) {
			EntryBlock entry = new EntryBlock(id,sub);
			entryPoints.add(entry);
			return entry;
		}
		if (label.equals("EXIT")){
			return new ExitBlock(id,sub);
		}
		String[] statements = label.split("\\|");
		List<IInstruction> instrs = new ArrayList<IInstruction>();
		for(String stmt : statements) {
			stmt = stmt.replace("\\l", "\n").replace("\\", "").replace("{", "").replace("}", "").trim();
			if(stmt.length()>0 && !stmt.contains("FREQ") && stmt.charAt(0) != '<') {
				if(stmt.charAt(0) == '[') {
					int end = stmt.indexOf(']');
					String[] pos = stmt.substring(1,stmt.indexOf(']')+1).split(":");
					instrs.add(new LocatedInstruction(pos[0], stmt.substring(end+1), 
							Integer.parseInt(pos[1])));
				}
				else {
					instrs.add(new Instruction(stmt));
				}
			}
		}
		
		return new BasicBlock(instrs, id,sub);
	}
	
	//NOT idempotent
	private void linkBlocks(Collection<String> edges) {
		for(String edge:edges) {
			String[] endpoints = edge.split("-");
			if(blockMap.containsKey(endpoints[0]) && blockMap.containsKey(endpoints[1])) {
				blockMap.get(endpoints[0]).addChild(blockMap.get(endpoints[1]));
			}
		}
	}
	
	public List<EntryBlock> getEntryPoints(){
		return entryPoints;
	}
	
	public Map<String, Block> getBlockMap(){
		return blockMap;
	}
	
	//TODO: Test dis
	public void mapSource(Path originalSourcePath) throws IOException {
		Scanner lineScanner = new Scanner(originalSourcePath);
		List<IOriginalLine> lineList = new ArrayList<IOriginalLine>();
		//Load lines (indexes should be lineno+1)
		int i =1;
		while(lineScanner.hasNext()) {
			lineList.add(new OriginalLine(lineScanner.nextLine(), i++));
		}
		lineScanner.close();
		//Scan for mapped instructions and link to corresponding lineno
		for(Block b : blockMap.values()) {
			if(b instanceof BasicBlock) {
				List<IInstruction> instructions = ((BasicBlock) b).getInstructions();
				for(i = 0; i < instructions.size(); i++) {
					IInstruction instr = instructions.get(i);
					if(instr instanceof ILocatedInstruction) {
						ILocatedInstruction locInstr = ((ILocatedInstruction) instr);
						int lineno = ((ILocatedInstruction) instr).getLineno();
						if(lineno <= lineList.size() && lineno > 0 && 
								locInstr.getFilename().equalsIgnoreCase(originalSourcePath.getFileName().toString())) {
							instructions.set(i, new MappedInstruction(locInstr, lineList.get(lineno-1)));
						}
					}
				}
			}
		}
	}
}

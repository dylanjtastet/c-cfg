package graph;

import java.util.List;

import com.paypal.digraph.parser.Subgraph;

public class BasicBlock extends Block {
	private List<IInstruction> instructions;
	private String id;
	
//	public BasicBlock(List<Block> children, List<Instruction> instructions, String id) {
//		super(id);
//		this.instructions = instructions;
//		this.setChildren(children);
//	}
	
	public BasicBlock(List<IInstruction> instructions, String id, Subgraph sub) {
		super(id, sub);
		this.instructions = instructions;
	}
	
	public List<IInstruction> getInstructions(){
		return this.instructions;
	}
	
	public void setInstructions(List<IInstruction> instructions) {
		this.instructions = instructions;
	}
	
	public void addInstruction(IInstruction instruction) {
		this.instructions.add(instruction);
	}
}

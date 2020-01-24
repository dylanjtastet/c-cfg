package graph;

import java.util.List;

public class BasicBlock extends Block {
	private List<IInstruction> instructions;
	private String id;
	
//	public BasicBlock(List<Block> children, List<Instruction> instructions, String id) {
//		super(id);
//		this.instructions = instructions;
//		this.setChildren(children);
//	}
	
	public BasicBlock(List<IInstruction> instructions, String id) {
		super(id);
		this.instructions = instructions;
	}
}

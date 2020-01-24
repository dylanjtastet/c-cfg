package graph;

public class Instruction implements IInstruction{

	private String text;
	public Instruction(String text) {
		this.text = text;
	}
	
	public Instruction() {}
	
	public String getText(){
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

}

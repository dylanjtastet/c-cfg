package graph;

public class LocatedInstruction extends Instruction implements ILocatedInstruction{
	private String filename;
	private int lineno;
	
	public LocatedInstruction(String filename, String text, int lineno) {
		super(text);
		this.filename = filename;
		this.lineno = lineno;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public int getLineno() {
		return lineno;
	}
	
	public void setLineno(int lineno) {
		this.lineno = lineno;
	}
	
}

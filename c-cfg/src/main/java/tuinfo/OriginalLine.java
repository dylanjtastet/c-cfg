package tuinfo;

public class OriginalLine implements IOriginalLine {

	private String text;
	private int lineno;
	
	public OriginalLine(String text, int lineno) {
		this.text = text;
		this.lineno = lineno;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public void setLineno(int lineno) {
		this.lineno = lineno;
	}

	public int getLineno() {
		return this.lineno;
	}

}

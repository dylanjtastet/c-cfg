package graph;

public class MappedInstruction implements IMappedInstruction {
	private ILocatedInstruction locInstr;
	private String origLine;
	public MappedInstruction(ILocatedInstruction instr, String origLine) {
		this.locInstr = instr;
		this.origLine = origLine;
	}
	public String getFilename() {
		return locInstr.getFilename();
	}
	public void setFilename(String filename) {
		locInstr.setFilename(filename);
	}
	public int getLineno() {
		return locInstr.getLineno();
	}
	public void setLineno(int lineno) {
		locInstr.setLineno(lineno);
	}
	public String getText() {
		return locInstr.getText();
	}
	public void setText(String text) {
		locInstr.setText(text);
	}
	public String getOriginalLine() {
		return origLine;
	}
	public void setOriginalLine(String line) {
		this.origLine = line;
	}
}

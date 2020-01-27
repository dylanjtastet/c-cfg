package graph;
import tuinfo.*;

public class MappedInstruction implements IMappedInstruction {
	private ILocatedInstruction locInstr;
	private IOriginalLine origLine;
	public MappedInstruction(ILocatedInstruction instr, IOriginalLine origLine) {
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
	public IOriginalLine getOriginalLine() {
		return origLine;
	}
	public void setOriginalLine(IOriginalLine line) {
		this.origLine = line;
	}
}

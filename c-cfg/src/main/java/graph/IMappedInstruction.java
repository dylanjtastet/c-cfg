package graph;

public interface IMappedInstruction extends ILocatedInstruction {
	public String getOriginalLine();
	public void setOriginalLine(String line);
}

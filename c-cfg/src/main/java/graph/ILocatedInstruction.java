package graph;

public interface ILocatedInstruction extends IInstruction {
	
	public String getFilename();
	
	public void setFilename(String filename);
	
	public int getLineno();
	
	public void setLineno(int lineno);
}

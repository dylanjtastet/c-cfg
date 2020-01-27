package graph;
import tuinfo.*;

public interface IMappedInstruction extends ILocatedInstruction {
	public IOriginalLine getOriginalLine();
	public void setOriginalLine(IOriginalLine line);
}

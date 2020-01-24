package graph;

import java.util.ArrayList;
import java.util.List;

public abstract class Block {
	private List<Block> children;
	private String id;
	public Block(String id) {
		this.id = id;
		this.children = new ArrayList<Block>();
	}
	public void setChildren(List<Block> children) {
		this.children = children; 
	}
	public List<Block> getChildren(List<Block> children) {
		return this.children;
	}
	public void addChild(Block child) {
		this.children.add(child);
	}
}

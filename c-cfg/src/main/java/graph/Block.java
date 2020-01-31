package graph;

import java.util.ArrayList;
import java.util.List;

import com.paypal.digraph.parser.Subgraph;

public abstract class Block {
	private List<Block> children;
	private Subgraph sub;
	private String id;
	public Block(String id, Subgraph sub) {
		this.id = id;
		this.children = new ArrayList<Block>();
		this.sub = sub;
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
	public Subgraph getSub() {
		return sub;
	}
	public void setSub(Subgraph sub) {
		this.sub = sub;
	}
}

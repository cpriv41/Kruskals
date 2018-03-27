package A3;

import java.lang.Object;

public class Vertex extends Object implements Comparable<Vertex> {

	public final int node;

	public Vertex(int node) {
		this.node = node;
	}

	public int getNode() {
		return node;
	}

	public int compareTo(Vertex element) {
		return Integer.valueOf(node).compareTo(element.node);

	}
	
	
	public String toString(){
		return Integer.toString(node);
	}
}

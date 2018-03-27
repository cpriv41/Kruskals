package A3;


public class Edge {

	public final int source;
	public final int destination;
	public final int weight;
	


	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	
	public int getDestination() {
		return destination;

	}

	public int getSource() {
		return source;
	}

	public int getWeight() {
		return weight;
	}
	
	
	public String toString(){
		return source + " " + destination + " " + weight;
	}



}



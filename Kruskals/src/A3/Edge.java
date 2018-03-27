package A3;



public class Edge implements Comparable<Edge> {

	public final int source;
	public final int destination;
	public final double weight;
	


	public Edge(int source, int destination, double weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	
	public int otherVertex(int vertex) {
		if ( vertex == source)
			return destination;
		else if (vertex == destination)
			return source;
		else throw new IllegalArgumentException("invalid endpoint");

	}

	public int getSource() {
		return source;
	}

	public double getWeight() {
		return weight;
	}
	
	
	public String toString(){
		return source + " " + destination + " " + weight;
	}


	@Override
	public int compareTo(Edge that) {
		// TODO Auto-generated method stub
		return Double.compare(this.weight, that.weight);
	}


}



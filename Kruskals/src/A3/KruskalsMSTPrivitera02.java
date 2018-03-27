package A3;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

//import com.sun.javafx.geom.Edge;

public class KruskalsMSTPrivitera02 {

	// TreeMap<Integer, Integer> T;
	LinkedList<Edge> T = new LinkedList<>();
	int numVertices;
	LinkedList<Vertex> vertices = new LinkedList<>();
	LinkedList<Edge> edges = new LinkedList<>();
	int source, destination;
	int u;
	int v;
	int w;
	Edge e;
	//Comparator<Edge> compare = new edgeComparator();
	PriorityQueue<Edge> pq = new PriorityQueue<>();
	int id;
	LinkedList<Vertex> vList = new LinkedList<>();

	public KruskalsMSTPrivitera02(File file) throws Exception {

		System.out.println(findMST(file));
		System.out.println("pq: " + pq);
		System.out.println("vertices: " + vertices);
		System.out.println("edges: " + edges);
		System.out.println("MST " + T.toString());

	}

	@SuppressWarnings("resource")
	public PriorityQueue<Edge> initializeHeap(File dataFile) throws Exception {

		Scanner edgeList = null;

		try {
			//FileInputStream inFile = new FileInputStream(dataFile);
			edgeList = new Scanner(dataFile);
			System.out.println("File " + dataFile + " has been opened");

			Pattern pat = Pattern.compile("c");
			while (edgeList.findInLine(pat) != null)
				edgeList.nextLine(); // no more comments

			numVertices = edgeList.nextInt();

			System.out.println("NumVertices " + numVertices);

			while (edgeList.hasNextLine()) {
				
				u = edgeList.nextInt();
				v = edgeList.nextInt();
				w = edgeList.nextInt();
				
				//e = new Edge(u, v, w);
				pq.add(new Edge(u, v, w));
				System.out.println(pq);
				System.out.println(" ( " + e.getSource() + " " + e.getDestination() + " " + e.getWeight() + " )  u: "
						+ u + " v: " + v + " w: " + w);
				
			}

		} catch (Exception e) {
			throw e;
		}
		return pq;

	}

	public String findMST(File dataFile) throws Exception {
		PriorityQueue<Edge> eQueue = initializeHeap(dataFile);
		compressWQU unionFind = new compressWQU(u);

		T = new LinkedList<>();

		while (T.size() < v) {
			Edge e = eQueue.remove();
			int source = e.getSource();
			int destination = e.getDestination();

			if (unionFind.find(source) != unionFind.find(destination)) {
				T.add(e);
				unionFind.union(source, destination);
			}
		}
		return toString();
	}

	public String toString() {
		return T.toString();
	}
}

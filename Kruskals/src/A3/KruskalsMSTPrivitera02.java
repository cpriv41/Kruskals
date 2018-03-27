package A3;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.regex.Pattern;

public class KruskalsMSTPrivitera02 {

	LinkedList<Edge> T = new LinkedList<>();
	int numVertices, numEdges;
	//LinkedList<Vertex> vertices = new LinkedList<>();
	//LinkedList<Edge> edges = new LinkedList<>();
	int source, destination;
	int u;
	int v;
	int w;
	
	Edge e;
	PriorityQueue<Edge> pq = new PriorityQueue<>();
	int id;
	LinkedList<Vertex> vList = new LinkedList<>();

	public KruskalsMSTPrivitera02(File file) throws Exception {

		System.out.println(findMST(file));

	}

	@SuppressWarnings("resource")
	public PriorityQueue<Edge> initializeHeap(File dataFile) throws Exception {

		Scanner edgeList = null;

		try {
			FileInputStream inFile = new FileInputStream(dataFile);
			edgeList = new Scanner(inFile);
			System.out.println("File " + dataFile + " has been opened");

			Pattern pat = Pattern.compile("c");
			while (edgeList.findInLine(pat) != null)
				edgeList.nextLine(); // no more comments

			numVertices = edgeList.nextInt();
			numEdges = numVertices - 1;

			System.out.println("NumVertices " + numVertices);

			while (edgeList.hasNextLine() != false) {

				u = edgeList.nextInt();
				v = edgeList.nextInt();
				w = edgeList.nextInt();

				e = new Edge(u, v, w);
				pq.add(e);
				System.out.println(pq);
				System.out.println(" ( " + e.getSource() + " " + e.otherVertex(e.getSource()) + " " + e.getWeight() + " )  u: "
						+ u + " v: " + v + " w: " + w);

			}

		} catch (Exception e) {
			throw e;
		}
		return pq;

	}

	public String findMST(File dataFile) throws Exception {
		PriorityQueue<Edge> edgeQueue = initializeHeap(dataFile);
		compressWQU unionFind = new compressWQU(numVertices);

		T = new LinkedList<>();

		while (T.size() < numEdges) {
			Edge e = edgeQueue.poll();
			int source = e.getSource();
			int destination = e.otherVertex(source);

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

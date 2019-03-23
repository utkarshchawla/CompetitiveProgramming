package aug_12;

public class Client {

	public static void main(String[] args) {

		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		g.addEdge("A", "B", 10);
		g.addEdge("A", "D", 40);
		g.addEdge("B", "C", 10);
		g.addEdge("C", "D", 10);
		g.addEdge("D", "E", 3);
		g.addEdge("E", "G", 8);
		g.addEdge("E", "F", 3);
		g.addEdge("F", "G", 3);
		// g.addEdge("A", "B", 1);
		// g.addEdge("B", "C", 1);
		// g.addEdge("C", "D", 1);
		// g.addEdge("D", "E", 1);
		// g.addEdge("E", "F", 1);
		// g.addEdge("F", "G", 1);
		// g.addEdge("G", "A", 1);

		g.display();
//		g.bft();
		// System.out.println(g.numEdges());
		// System.out.println(g.numVertices());

		// System.out.println(g.hasPath("D", "F"));
		// g.printpath("D", "G");
		// System.out.println(g.bfs("A", "G"));
		// g.bft();
		// System.out.println(g.isBipartite());
		// System.out.println(g.isBipartite2());
		// System.out.println(g.isConnected());
		// System.out.println(g.isCyclic());
		// System.out.println(g.isTree());
		 System.out.println(g.djikstra("A"));
//		 g.PrimsMST().display();

	}

}

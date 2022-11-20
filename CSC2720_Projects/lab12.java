import java.util.Iterator;
import java.util.LinkedList;


public class lab12 {

	/* Class representing a directed graph using adjacency lists */
	static class Graph
	{
		int V; //Number of Vertices
		LinkedList<Integer>[] adj; // adjacency lists
		//Constructor
		Graph(int V)
		{
			this.V = V;
			adj = new LinkedList[V];
			for (int i = 0; i < adj.length; i++)
				adj[i] = new LinkedList<Integer>();
		}
		//To add an edge to graph
		void addEdge(int v, int w)
		{
			adj[v].add(w); // Add w to the list of v.
		}

		void dfs_func(int v, boolean visit[]) { // method to be used by dfs
			visit[v] = true; //pointing the first node as visited and printing it
			System.out.print(v + " ");
			Iterator<Integer> count = adj[v].listIterator(); // using recursion for all the vertices adjacent to this vertex
			while(count.hasNext()) { //loop to visit all the nodes on the graph
				int no = count.next();
				if(!visit[no]) { // recursing 
					dfs_func(no, visit);
				}
			}
		}

		public static void main(String args[]) {
			Graph g = new Graph(6);
			boolean visitNodes[] = new boolean[6]; // array to store visited nodes
			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(2, 3);
			g.addEdge(2, 4);
			g.addEdge(4, 5);
			g.addEdge(1, 3);
			g.addEdge(3, 5);
			System.out.println("The Depth first Traveresal with source 0 is");
			g.dfs_func(0,visitNodes);

		}
	}
}
/* Time Complexity for this program is O(V + E)
 * Space Complexity for this program is O(V)  */

//Performing a BFS Traversal on a Binary Tree


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lab13 {
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
	}

	public static void main(String[] args) {
		boolean visitNodes[] = new boolean[6]; // array to store visited nodes
		Graph g = new Graph(6);
		g.addEdge(0, 1); 
		g.addEdge(0, 2);  
		g.addEdge(2, 3);
		g.addEdge(2, 4); 
		g.addEdge(4, 5);  
		g.addEdge(1, 3);
		g.addEdge(3, 5);
		Queue<Integer> bfs = new LinkedList<Integer>(); //Queue for BFS Traversal
		bfs.add(0); //adding the first node
		Arrays.fill(visitNodes, false); //using the fill function to store false for the first visited node
		System.out.print("BFS Traversal => ");
		visitNodes[0] = true; //marking the 0 index as true
		while (bfs.isEmpty() == false) { //checks if the stack is empty or not and performs BFS traversal
			int  num = bfs.remove(); //stores the first queue data into the num variable
			System.out.print(num+" "); //printing the number out
			for (int element : g.adj[num]){ //loop o check the rest of the nodes
				if(visitNodes[element] == false) { //checks if the the node is not visited, marks it as true
					visitNodes[element] = true;
					bfs.add(element); //add the element back to the stack
				}
			}
		}
	}
}

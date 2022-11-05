//This is Muhammad Abdullah Nasir CSC 2720 Lab 10

/* Time Complexity for this program is O(n)
 * Space Complexity for this program is O(n)
 */

import java.util.ArrayDeque;

class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree { //declaring a binary tree
	Node root; 	
	public BinaryTree() {
		root = null;
	}

}

public class lab10_binaryTree {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(7);
		travelOrder(tree.root); //calling the function to print the data of binary tree.
	}

	public static void travelOrder(Node root) {
		ArrayDeque<Node> queue = new ArrayDeque<>(); //a queue for adding data from binary tree
		if(root == null) return;
		queue.add(root); //adding root of binary tree
		while(!queue.isEmpty()) {
			Node curr = queue.peek(); 
			System.out.print(curr.data+" "); //printing the data
			if(curr.left != null)queue.add(curr.left); //adding left element
			if(curr.right != null)queue.add(curr.right); //adding right element
			queue.remove();
		}
	}
}

/*
 * Test Cases
 * What happens if a user enters values for binary tree and there is an illegal number found in the tree?
 * In this case, we can add a statement to print that the user entered a wrong number for binary data
 * 
 * else {
 * 		System.out.println("Error: no or invalid number found, enter a valid number");
 * }
 */

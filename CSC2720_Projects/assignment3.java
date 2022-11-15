//This is Muhammad Abdullah Nasir CSC 2720 Assignment 3

/* Time Complexity for this program is O(n)
 * Space Complexity for this program is O(n)
 */
class Node {
	int data;
	Node left, right;
	public Node(int item)
	{
		data = item;
		left = null;
		right = null;
	}
}

public class assignment3 {
	Node root = null;
	
	public Node delete_node(Node root, int data) { //delete node method, uses recursion, to check the node to delete
		if (root == null) {
			return root;
		}
		if (data < root.data) { //if data is less, moves left
			root.left = delete_node(root.left, data);
		} else if (data > root.data) {
			root.right = delete_node(root.right, data); //if data is greater, moves right
		} else {
			if (root.left == null) { //checks if left root is null, and returns right
				return root.right;
			} else if (root.right == null) { //checks if right root is null, and returns left
				return root.left;
			}
			root.data = minimum(root.right); //
			root.right = delete_node(root.right, root.data);
		}
		return root;
	}

	public int minimum(Node root) { //method to check for minimum value
		int val = root.data;
		while (root.left != null) {
			val = root.left.data;
			root = root.left;
		}
		return val; //returns minimum value
	}
	
	public void in_order(Node root) { //printing the tree with in-order traversal
		if (root != null) {
			in_order(root.left);
			System.out.print(root.data + " ");
			in_order(root.right);
		}
	}

	public static void main(String[] args) {
		assignment3 tree = new assignment3();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(7);
		tree.delete_node(tree.root, tree.root.data); //passing the tree for deleting the root node value
		tree.in_order(tree.root); // printing the data
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
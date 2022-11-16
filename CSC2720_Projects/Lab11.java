//This is Muhammad Abdullah Nasir CSC 2720 Lab 11

/* Time Complexity for this program is O(n)
 * Space Complexity for this program is O(n)
 */

/* Class to represent Tree node */
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
public class Lab11 {
	Node root;
	public boolean checkTrueBST(Node root,long low, long high){
		if(root == null) { //checking if it's a leaf node
			return true;
		} if(root.data <= low || root.data >= high) { //checking if the data is out of range
			return false;
		}
		//checking the left sub-tree with the values, if it is true or not
		boolean isLeftSubTreeValid = checkTrueBST(root.left, low, root.data);

		//checking the right sub-tree with the values, if it is true or not
		boolean isRightSubTreeValid = checkTrueBST(root.right, root.data, high);

		return (isLeftSubTreeValid && isRightSubTreeValid); //if both are valid, return true or false

	}

	public boolean checkBST() {
		return checkTrueBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public static void main(String[] args) {
		Lab11 tree = new Lab11();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(7);
		if(tree.checkBST()) {
			System.out.println("True");
		} else {       
			System.out.println("False");
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

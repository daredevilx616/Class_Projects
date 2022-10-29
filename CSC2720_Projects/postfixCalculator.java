//This is Muhammad Abdullah Nasir CSC 2720 Lab 8

/* Time Complexity for this program is O(n)
 * Space Complexity for this program is O(n)
 */

import java.util.*;
import java.util.Stack;

public class postfixCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String exp; // declaring a string to store the expression
		System.out.print("Enter a postfix expression to be calculated: ");
		exp = sc.nextLine(); //takes the expression from the user
		System.out.println("Answer for the expression: " + exp + " = " + postFix(exp)); //prints out the final answer
		sc.close();
	}

	public static double postFix(String exp) { //Method to calculate the postfix expression

		Deque<Integer> stack = new ArrayDeque<Integer>(); 	//Stack to store each value
		int num1, num2;
		String[] items = exp.split(" "); //using split() function, to store each letter in an array of String
		for(int i = 0; i<items.length; i++) { //loop to pass each string number
			switch(items[i]) { //Case switch to check and calculate for each operator in the string array

			case "+": //addition						
				num1 = stack.pop(); //Popping two elements and adding their result in the stack
				num2 = stack.pop();
				stack.push(num2 + num1); 
				break;

			case "-": //subtraction
				num1 = stack.pop(); //Popping two elements and adding their result in the stack
				num2 = stack.pop();
				stack.push(num2 - num1);
				break;

			case "*": //multiplication
				num1 = stack.pop(); //Popping two elements and adding their result in the stack
				num2 = stack.pop();
				stack.push(num2 * num1);
				break;

			case "/": //division
				num1 = stack.pop(); //Popping two elements and adding their result in the stack
				num2 = stack.pop();
				stack.push(num2 / num1);
				break;

			case " ": //case for skipping all the spaces
				break;

			default:
				stack.push(Integer.parseInt(items[i])); //pushes the number in the stack if no operator is found
				break;
			}
		}
		return stack.pop(); //answer
	}
}

/*
 * Test Cases
 * What happens if there is a illegal operator or no operator found in the expression?
 * 	In this case, we can change the default statement to print that the user entered a wrong operator
 * 
 * default:
 * 		System.out.println("Error: no or invalid operator found, enter a valid operator");
 * 		break;
 */

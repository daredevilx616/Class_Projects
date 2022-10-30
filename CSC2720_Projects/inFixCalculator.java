//This is Muhammad Abdullah Nasir CSC 2720 Assignment 2

/* Time Complexity for this program is O(n)
 * Space Complexity for this program is O(n)
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class inFixCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String exp; // declaring a string to store the expression
		System.out.print("Enter an in-fix expression to be calculated: ");
		exp = sc.nextLine(); //takes the expression from the user
		System.out.println("Answer for the expression: " + exp + " = " + inFix(exp)); //prints out the final answer
		sc.close();
	}
	public static int inFix(String expression) {
		Deque<Integer> stack = new ArrayDeque<Integer>(); 	//Stack to store each value
		Deque<Character> oper = new ArrayDeque<Character>(); //Stack to store each operator
		int output;
		for(int i=0; i<expression.length();i++) {
			char item = expression.charAt(i);
			if(Character.isDigit(item)){ //checks if the item is a number, if it is a number it will store it in the stack
				int num = 0;
				while (Character.isDigit(item)) {
					num = num * 10 + (item - '0'); //A number could be >10 so we're are checking if there is another digit right next to it
					i++;
					if(i < expression.length())
						item = expression.charAt(i);
					else
						break;
				}
				i--;
				stack.push(num); //adding it into stack

			} else if(isOperator(item)) {  //checks if the item is an operator, if it is an operator it will store it in the operator stack

				while(!oper.isEmpty()){
					output = calculate(stack, oper); //sends the operator and number stacks to calculate whichever operator comes first
					//push it back to stack
					stack.push(output);
				}
				oper.push(item); //adding it into oper stack
			}
		}

		while(!oper.isEmpty()){
			output = calculate(stack, oper);

			stack.push(output); //adds the newly calculated answer to the stack to perform the rest of the calculations
		} 
		output = stack.pop();
		return output; //final answer returns
	}


	public static int calculate(Deque<Integer> num, Deque<Character> oper) { //calculation method for each case 
		int num1 = num.pop(); //takes out the first number
		int nunm2 = num.pop(); //takes out the second number
		char operation = oper.pop(); //takes out the first operator
		switch (operation) { //performs operations
		case '+':
			return num1 + nunm2;
		case '-':
			return nunm2 - num1;
		case '*':
			return num1 * nunm2;
		case '/':
			if (num1 == 0) throw new UnsupportedOperationException("Can't be divide by zero");
			return nunm2 / num1;
		}
		return 0;
	}

	public static boolean isOperator(char item) { //method to check which operator is in the characters
		return (item=='+'||item=='-'||item=='/'||item=='*');
	}
}


/*
 * Test Cases
 * What happens if there is an illegal operator or no operator found in the expression?
 * In this case, we can change the default statement to print that the user entered a wrong operator
 * 
 * else {
 * 		System.out.println("Error: no or invalid operator found, enter a valid operator");
 * 		break;
 * }
 */


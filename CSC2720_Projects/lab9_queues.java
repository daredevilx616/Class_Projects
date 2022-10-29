//This is Muhammad Abdullah Nasir's Lab9 CSC2720
//Time Complexity: O(1)  || Space Complexity: O(n)
import java.util.ArrayDeque;
import java.util.Deque;

public class lab9_queues {
	public static void enqueue(int a, Deque<Integer> Main_Queue, Deque<Integer> Max_Queue) {
		//method to add elements in the main and max queue, and checks for the max element to let them remain in the main queue
		Main_Queue.add(a);
		while(true) {
			if(Max_Queue.size() > 0) {
				int i = Max_Queue.getLast();
				if(i < a) {  //checks if the last element is smaller than the new one
					Max_Queue.pollLast(); //removes the last element
				}
				else {
					Max_Queue.add(a); //adds the new element
					break;
				}
			}
			else {
				Max_Queue.add(a); //add the new element
				break;
			}
		}
	}

	public static void dequeue(Deque<Integer> Main_Queue, Deque<Integer> Max_Queue) {
		//method to dequeue from both main and max queue
		int remove;
		if(Main_Queue.size() > 0) {
			remove = Main_Queue.pollFirst(); //removes an element
			if(remove == Max_Queue.peek()) { //checks if to remove an element from max queue as well
				Max_Queue.pollFirst();
			}
		}
	}
	public static void printQueue(Deque<Integer> Main_Queue, Deque<Integer> Max_Queue) { 
		//method to print the queues
		System.out.println("Main Queue: "+Main_Queue);
		System.out.println ("Max Queue: "+Max_Queue+"\n");
	}

	public static void main(String[] args) {

		//Declaration of Double ended queues, so that insertion and deletion is possible from both the ends
		Deque<Integer> Main_Queue = new ArrayDeque<>();
		Deque<Integer> Max_Queue = new ArrayDeque<>();

		int a= 1, b= 4, c= 2, d= 3; //declaring the elements to add

		System.out.println("Queue: ");
		enqueue(a, Main_Queue, Max_Queue);
		printQueue(Main_Queue, Max_Queue);

		System.out.println("Adding 4 in the queue: ");
		enqueue(b, Main_Queue, Max_Queue);
		printQueue(Main_Queue, Max_Queue);

		System.out.println("Adding 2 in the queue: ");
		enqueue(c, Main_Queue, Max_Queue);
		printQueue(Main_Queue, Max_Queue);

		System.out.println("Adding 3 in the queue: ");
		enqueue(d, Main_Queue, Max_Queue);
		printQueue(Main_Queue, Max_Queue);

		System.out.println("After dequeuing the first two elements: ");
		dequeue(Main_Queue, Max_Queue);
		dequeue(Main_Queue, Max_Queue);
		printQueue(Main_Queue, Max_Queue);

	}
}

/*Test case:
 * What if the we take the user input and he enter a non-integer element?
 * we will use a try catch block to catch any exceptions and prompt the user
 * that he entered a wrong character and will ask the user to re enters the integer.
 * 
 * try{
 * int num = sc.nextInt();
 * enqueue(num, Main_Queue, Max_Queue);
 * }
 * catch(Exeption e) {
 * System.out.println("You entered a wrong integer");
 * }
 */

import java.util.*;

public class Num2WordsRecur {

	static String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six", 
			"seven", "eight", "nine", "ten", "eleven", "twelve",
			"thirteen", "fourteen", "fifteen", "sixteen", "seventeen", 
			"eighteen", "nineteen" };
	static String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty",
			"sixty", "seventy", "eighty", "ninety" };

	public static void main(String[] args) {
		int number = 0;
		Scanner SCinput = new Scanner(System.in);
		System.out.println("Please type an integer number(max upto 9 digits): ");
		try {
			number = SCinput.nextInt();
			System.out.print("Number in words: " + numToWord(number));
		} 
		catch (Exception e) {
			System.out.println("Please enter a valid number");
		}
		SCinput.close();

	}

	private static String numToWord(int num) {
		String words = "";
		if (num == 0) {
			return "zero";
		} if (num < 0) { 
			String number = "" + num;
			number = number.substring(1);
			return "minus " +numToWord(Integer.parseInt(number));

		} if(num/1000000 > 0) {
            return numToWord(num/1000000) + " million " + numToWord(num%1000000);

		} if(num/1000 > 0) {
            return numToWord(num/1000) + " thousand " + numToWord(num%1000);

		} if(num/100 > 0) {
            return numToWord(num/100) + " hundred " + numToWord(num%100);

		} if (num > 0) {
			if (num < 20) { 
				words += unitsArray[num];
			} else { 
				words += tensArray[num/10]; 
				if ((num % 10) > 0) {
					words += "-" + unitsArray[num%10];
				}  
			}
		}
		return words;
	}
}

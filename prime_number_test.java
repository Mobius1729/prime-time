package mathematicalPrograms;

import java.util.ArrayList;
import java.util.Scanner;

public class prime_number_test {

	private static Scanner userInput = new Scanner(System.in);
	private static int counter = 0;
	private static ArrayList<Integer> factors = new ArrayList<Integer>();
	private static String finalFactors = "";
	private static ArrayList<String> newFactors = new ArrayList<String>();
	/* Scanner used for user input in Console. 
	 * counter counts how many factors a number has.
	 * factors is an ArrayList which contains all the factors of a number.
	 */
	// variables are static due to use in static method.

	// method for determining which numbers are prime
	public static void prime_number(int num) {
		for(int x=1; x<=(num); x++ ) {
			// for loop tests the divisibility of all integers from 1 to num
			if(num % x == 0) {
				counter += 1;
				factors.add(x);	
				// if num is divisible by a specific value of x, x is a factor of num.
				// counter increases by 1, and we append value of x to factors.
			}
		}
		for(int f: factors) {
			newFactors.add(Integer.toString(f));
			// convert all integer elements in ArrayList factors to string.
			finalFactors = String.join(", ", newFactors);
			// joins all String elements in finalFactors with ,.
		}
		if(num == 1){
			// if userInput is 1
			System.out.println("1 is neither prime nor composite.");
		} else if(counter > 2) {
			// if userInput has number with more than 2 factors
			System.out.println("Your number, " + num + ", is not prime.");
			System.out.println("The factors of " + num + " are: " + finalFactors);
		} else{
			// if userInput has number with less than 2 factors
			System.out.println("Your number, " + num + ", is prime.");
			System.out.println("The only factors of your number are: " + finalFactors);

		} 
		factors.clear();
		counter = 0;
		// clear factors for next num (factors were being appended when user inputed new num).
		// reset counter to 0 (counter kept incrementing when user inputed new num).
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			do {
				System.out.println("Please enter a positive integer.");
				prime_number(userInput.nextInt());
				System.out.println('\n');
			}while(true);

		}catch(java.util.InputMismatchException ex) {
			System.out.println("Your number must be less than 2,147,483,648.");
			// integer holds max value of 2^32. Ensures InputMismatchException is not thrown.
		}
	}

}

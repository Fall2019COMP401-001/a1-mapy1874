package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		// Read in the number of customers
		int count = scan.nextInt();
		
		/* Use the for loop to get the info of
		 * every customers and print separately
		*/
		for (int i = 0; i < count; i++)
		{
			String firstName = scan.next();
			String lastName = scan.next();
			int numOfItems = scan.nextInt();
			
			double sum = 0;
			int amount;
			double price;
			String itemName;
			//get every item's info and sum up
			for (int j = 0; j < numOfItems; j++)
			{
				amount = scan.nextInt();
				itemName = scan.next();
				price = scan.nextDouble();
				sum += amount*price;
			}
			String stringSum = String.format("%.2f", sum);

			//output the result
			System.out.println(firstName.charAt(0)+". " + lastName + ": "
			+ stringSum);
		}
	}
}

package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.

		// Read in the number of items in the store
		int numStoreItems = scan.nextInt();
		//itemList stores the names of items
		String[] itemList = new String[numStoreItems];
		//itemPrice stores the matched price for each item
		double[] itemPrice = new double[numStoreItems];
		//construct the item list and their price
		for (int i = 0; i < numStoreItems; i++)
		{
			itemList[i] = scan.next();
			itemPrice[i] = scan.nextDouble();
		}
		
		int numCustomers = scan.nextInt();
		/* Use the for loop to get the info of
		 * every customers
		 * bigFirstName, bigLastName, bigAmount
		 * store the info of biggest amount cus
		 * smallFirstName, smallLastName,smallAmount
		 * store the info of smallest amount cus
		 * avgAmount is the avg of the sum of amount
		*/
		String bigFirstName=null, bigLastName=null,
				smallFirstName=null, smallLastName=null;
		String firstName, lastName;
		double bigAmount=0, smallAmount=0, avgAmount=0;
		int numItemsPurch;
		//sumForAvg is the total money for all customers
		double sumForAvg = 0;
		for (int i = 0; i < numCustomers; i++)
		{
			firstName = scan.next();
			lastName = scan.next();
			//the number of items every cus purchased
			numItemsPurch = scan.nextInt();
			
			//sum is the money every customer pays
			double sum = 0;
			
			// amount is the num of per purchased item
			// index is the position of the item in array
			int amount, index;
			String itemName;
			
			//get every item's info for a customer
			for (int j = 0; j < numItemsPurch; j++)
			{
				amount = scan.nextInt();
				itemName = scan.next();
				index = findStringIndex (itemList, itemName);
				sum += amount * itemPrice[index];
			}
			if (i == 0)//first customer's info
			{
				bigFirstName = firstName;
				bigLastName = lastName;
				bigAmount = sum;
				smallFirstName = firstName;
				smallLastName = lastName;
				smallAmount = sum;
			}
			// this customer spend more
			else if (sum > bigAmount)
			{
				//update the information
				bigFirstName = firstName;
				bigLastName = lastName;
				bigAmount = sum;
			}
			//this customer spend less
			else if (sum < smallAmount)
			{
				//update the information
				smallFirstName = firstName;
				smallLastName = lastName;
				smallAmount = sum;
			}
			// sum up every customer's spent
			sumForAvg += sum;
		}
		
		String stringAvgSum = String.format("%.2f", sumForAvg/numCustomers);
		String stringBigAmount = String.format("%.2f", bigAmount);
		String stringSmallAmount = String.format("%.2f", smallAmount);
		System.out.println("Biggest: "+bigFirstName+" "+bigLastName+" ("+ 
		stringBigAmount+")");
		System.out.println("Smallest: "+smallFirstName+" "+smallLastName+" ("+ 
		stringSmallAmount+")");
		System.out.println("Average: "+stringAvgSum);
	}
	
	/* findStringIndex
	 * findStringIndex is a method to find the targer string in a string array
	 * 
	 * Input: a string array and the target string
	 * 
	 * Output: interger index of that string in the target string array
	 * 		   if not found, return -1
	 * 
	 * Preconditions: input string array cannot be null
	 */
	
	static int findStringIndex (String[] s, String target)
	{
		for (int i = 0; i < s.length; i++)
		{
			if(target.equals(s[i])) return i;
		}
		//no matched string
		return -1;
	}
	
	}


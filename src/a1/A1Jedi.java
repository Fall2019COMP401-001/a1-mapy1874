package a1;

import java.util.Scanner;

public class A1Jedi {
	
	public static void main(String[] args) {
			
			Scanner scan = new Scanner(System.in);
	
			// Your code follows here.
	
			// Read in the number of items in the store
			int numStoreItems = scan.nextInt();
			//itemList stores the names of items
			String[] itemList = new String[numStoreItems];
			//itemPrice stores the matched price for each item
			double[] itemPrice = new double[numStoreItems];
			//use the counter to memorize the num of every bought item
			int [] arrayCounter = new int [numStoreItems];
			//initialize the arrayCounter
			for (int i = 0; i < numStoreItems; i++) arrayCounter[i] = 0;
			//use the counter to memorize the num of customers bought a specific item
			int [] arrayCounterCus = new int [numStoreItems];
			//initialize the arrayCounterCus
			for (int i = 0; i < numStoreItems; i++) arrayCounterCus[i] = 0;
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
//			String bigFirstName=null, bigLastName=null,
//					smallFirstName=null, smallLastName=null;
			String firstName, lastName;
//			double bigAmount=0, smallAmount=0, avgAmount=0;
			int numItemsPurch;
			//sumForAvg is the total money for all customers
			double sumForAvg = 0;
			//flag whether customers bought items or not
			boolean bought = false;
			for (int i = 0; i < numCustomers; i++)
			{
				firstName = scan.next();
				lastName = scan.next();
				//the number of items every cus purchased
				numItemsPurch = scan.nextInt();
								
				// amount is the num of per purchased item
				// index is the position of the item in array
				int amount, index;
				String itemName;
				//noRepeatedNumCus used for avoid repeated items for the
				//same customer
				Boolean[] noRepeatedNumCus = new Boolean[numStoreItems];
				for (int k = 0; k < numStoreItems; k++) noRepeatedNumCus[k] = false;

				//get every item's info for a customer
				for (int j = 0; j < numItemsPurch; j++)
				{
				    amount = scan.nextInt();
					itemName = scan.next();
					index = findStringIndex (itemList, itemName);
					
					arrayCounter[index] += amount;
					//someone bought some items
					if (amount != 0) 
					{	
						bought=true;
						//this customer have not bought the item
						//previously
						if(!noRepeatedNumCus[index])
						{
							arrayCounterCus[index]++;
							noRepeatedNumCus[index] = true;
						}
					}
				}
			}
			
			for (int i = 0; i < numStoreItems; i++)
			{
				//no one bought item
				if(!bought)
				{
					System.out.println("No customers bought ITEM");
					break;
				}
				else 
				{
					//no customer bought this item
					if (arrayCounter[i] == 0)
						System.out.println("No customers bought "+itemList[i]);
					else//some one bought at least one of this items
					{
						System.out.println(arrayCounterCus[i]+" customers bought "+
									arrayCounter[i]+" "+ itemList[i]);
					}
				}
			}
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


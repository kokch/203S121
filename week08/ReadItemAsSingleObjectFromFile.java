package inputoutput;

import java.io.*;
import java.util.*;

/**
 * A Java application that create Item objects from a binary file.
 * Detail of each Item object is read using a FileInputStream object wrapped in
 * a ObjectInputStream object. Item object read from file is then stored
 * in a Collection object. Lastly the detail information about each Item object 
 * is displayed, together with the total price of all items.
 */
public class ReadItemAsSingleObjectFromFile
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = kbd.nextLine();

		ArrayList<Item> list = new ArrayList<Item>(); // for storing Item objects

		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);)
		{

			Item item = null;
			try
			{
				item = (Item) ois.readObject(); // read first object
				list.add(item);                 // add to collection
			}
			catch (IOException ioe)	// when end of file is encountered
			{						// an IOException is thrown
				item = null;        // set item to null
			}
			
			while (item != null)    // if it is not end of file yet.
			{
				try                 // read in more Item objects
				{
					item = (Item) ois.readObject();
					list.add(item); // stored in list
				}
				catch (IOException ioe) // eof encountered, exception is thrown
				{
					item = null;        // set item to null to exit while loop
					System.out.println("End of file reached.");
				}                       // just to tell user eof is reached
			}                           // NOT required...
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("File '" + fileName + "' does not exits");
			return;
		}
		catch (IOException ioe)
		{
			System.out.println("Error in reading");
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println(cnfe.getMessage());
		}

		// display details of each Item obejct, and compute the total price
		double totalPrice = 0.0;
		Iterator<Item> itr = list.iterator();
		while (itr.hasNext())
		{
			Item item = itr.next();
			System.out.println(item.toString());
			totalPrice += item.getPrice();
		}
		System.out.printf("Total price: %1.2f\n", totalPrice);
	}
}


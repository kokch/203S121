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
public class ReadArrayListOfItemAsSingleObjectFromFile
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = kbd.nextLine();

		ArrayList<Item> list = new ArrayList<Item>(); // for storing Item objects
		ObjectInputStream ois = null;

		try
		{
			FileInputStream fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			
			list = (ArrayList<Item>) ois.readObject();
		
			ois.close();
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


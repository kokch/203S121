package inputoutput;

import java.io.*;
import java.util.*;

/**
 * A Java application that store Item objects to a binary file.
 * Each Item objects' information is entered by user through keyboard, and 
 * stored in a Collection object such as ArrayList.
 * This application uses a FileOutputStream object wrapped in a ObjectOutputStream
 * object for writing Item data to a binary file.
 * Information stored can be read back by the file
 *			'ReadItemAsSingleObjectFromFile.java'.
 */
public class WriteArrayListOfItemAsSingleObjectToFile
{
	public static void main(String[] args)
	{
		ArrayList<Item> list = new ArrayList<Item>(); // for storing Item objects
        Scanner kbd = new Scanner(System.in);

		System.out.println("Saving items information into file");
		System.out.print("Enter item name. Press <Enter> to quit: ");
		String itemName = kbd.nextLine();
		while (!itemName.trim().equals(""))
		{
			System.out.print("Enter price: ");
			double itemPrice = kbd.nextDouble();
			Item item = new Item(itemName, itemPrice);
			list.add(item);

                        kbd.nextLine();
			System.out.print("Enter item name. Press <Enter> to quit: ");
			itemName = kbd.nextLine();
		}

		if (list.size() == 0)
			System.out.println("No items entered.");
		else
		{
			System.out.print("Enter file name: ");
			String fileName = kbd.nextLine();
			try
			{
				ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(fileName));
				oos.writeObject(list);	// throws InvalidClassException
				oos.flush();		//    and NotSerilizableException
				oos.close();		//    and IOException, in this order
			}
			catch (IOException ioe)
			{
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
				return ;
			}
		}
	}
}


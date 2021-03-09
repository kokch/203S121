package inputoutput;

import java.io.*;
import java.util.*;


/**
 * A Java application that create Item objects from a text file.
 * Detail of each Item object is stored on different line in the text file. The
 * attributes are separated by using comma (,) as the delimeter.
 * These attributes are extracted by using a StringTokenizer object. Each Item
 * object created is then stored in a Collection object. Lastly the detail
 * information about each Item object is displayed, together with the
 * total price of all items.
 */
public class ReadItemsFromFile
{
	public static void main(String[] args)
	{
            Scanner kbd = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = kbd.nextLine();

		ArrayList<Item> list = new ArrayList<Item>(); // for storing Item objects
		//FileReader fr = null;
		//BufferedReader br = null;

		try (FileReader fr = new FileReader(fileName);
			 BufferedReader	br = new BufferedReader(fr);)
		{
			String line = br.readLine();
			while (line != null) // null indicates end of file
			{
				StringTokenizer st = new StringTokenizer(line, ",");
				String itemName = st.nextToken();
                double itemPrice = Double.parseDouble(st.nextToken());
				Item item = new Item(itemName, itemPrice);
				list.add(item);

				line = br.readLine();
			}
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
		
		
		// display details of each Item obejct, and compute the total price
		double totalPrice = 0.0;
		Iterator<Item> itr = list.iterator();
		while (itr.hasNext())
		{
			Item item = (Item) itr.next();
			System.out.println(item.toString());
			totalPrice += item.getPrice();
		}
		System.out.println("Total price: " + totalPrice);
	}
}


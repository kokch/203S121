package inputoutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author KokChyeHock
 */
public class WriteItemsToFilePW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        ArrayList<Item> list = new ArrayList<>();
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
            File file = new File(fileName);
            FileWriter fw = null;

            try
            {
                if (file.exists())
                {
                    System.out.println("File '" + fileName + "' already exists.");
                    System.out.print("Choose <y>es to overwrite or <n>o to append: ");
                    char response = kbd.nextLine().charAt(0);
                    if (response == 'y' || response == 'Y')
                            fw = new FileWriter(fileName); // throws IOException
                    else
                            fw = new FileWriter(fileName, true);
                }
                else
                    fw = new FileWriter(fileName);

                PrintWriter pw = new PrintWriter(fw);

                Iterator itr = list.iterator();
                while (itr.hasNext())
                {
                    Item item = (Item) itr.next();
                    pw.println(item.getName() + "," + item.getPrice());
                    /*
                            pw.print(item.getName());
                            pw.print(",");
                            pw.println(item.getPrice());
                    */
                }
                pw.flush(); 
                pw.close(); 
            }
            catch (IOException ioe)
            {
                System.out.println(ioe.getMessage());
                return ;
            }
        }
    }
    
}


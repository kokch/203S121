package inputoutput;

import java.io.*;
import java.util.Scanner;

public class SumInt {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = kbd.nextLine();
		
		try ( FileReader fr = new FileReader(fileName);
			  BufferedReader br = new BufferedReader(fr);)
		{
			int total = 0;
			String line = br.readLine();
			while (line != null) // null indicates end of file
			{
				total = total + Integer.parseInt(line);
				line = br.readLine();
			}
			System.out.println("Total is " + total);
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
	}
}


package inputoutput;

import java.io.*;
import java.util.Scanner;

/**
 * A Java application that display the contents of a file as byte streams.
 * This application uses the byte stream – FileInputStream – for reading data.
 * Output is displayed as sequence of bytes.
 */
public class ReadFromFile02b
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = kbd.nextLine();
		
		try (FileInputStream fis = new FileInputStream(fileName);)
		{	
			byte inByte;
			inByte = (byte) fis.read();
			while (inByte != -1) // -1 indicates end of file
			{
				System.out.print((char) inByte);
				inByte = (byte) fis.read();
			}
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("File '" + fileName + "' does not exits");
		}
		catch (IOException ioe)
		{
			System.out.println("Error in reading");
		}
		kbd.close();
	}
}


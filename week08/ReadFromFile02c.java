package inputoutput;

import java.io.*;
import java.util.Scanner;

/**
 * A Java application that display the contents of a file as byte streams.
 * This application uses the byte stream – FileInputStream – for reading data.
 * Output is displayed as sequence of bytes.
 */
public class ReadFromFile02c
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = kbd.nextLine();
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(fileName);
			
			byte inByte;
			inByte = (byte) fis.read();
			while (inByte != -1) // -1 indicates end of file
			{
				System.out.print(inByte); // (char) inByte);
				inByte = (byte) fis.read();
			}
			
			if (fis != null)
				fis.close();
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


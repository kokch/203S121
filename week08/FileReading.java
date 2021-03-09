package inputoutput;

import java.io.*;
import java.util.Scanner;

/**
 * A Java application that display the contents of a file as byte streams.
 * This application uses the byte stream – FileInputStream – for reading data.
 * Output is displayed as sequence of bytes.
 */
public class FileReading
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = kbd.nextLine();
		
		try (FileReader fis = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fis); )
		{	
			String aLine = br.readLine();
			while (aLine != null) // null indicates end of file
			{
				System.out.println(aLine);
				aLine = br.readLine();
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
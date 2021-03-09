package inputoutput;

import java.io.*;
import java.util.Scanner;

public class ReadFromFile01
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
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("File '" + fileName + "' does not exits");
			return;
		}
	}
}


package inputoutput;

import java.io.*;
import java.util.Scanner;

public class ReadFromFile
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner kbd = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = kbd.nextLine();
		FileInputStream fis = null;
		fis = new FileInputStream(fileName);
	}
}


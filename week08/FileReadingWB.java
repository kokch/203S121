package inputoutput;

import java.io.*;
import java.util.Scanner;
/**
* A Java application that display the contents of a file as character 
* streams. This application uses the character stream – FileReader – 
* for reading data. The FileReader object is passed as an argument to 
* a BufferedReader object to * improve reading and writing efficiency.
* Output is displayed as sequence of characters.
*/
public class FileReadingWB
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in); 
		System.out.print("Enter file name: "); 
		String fileName = kbd.nextLine(); 
		
		try (FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);) 
		{
			String line = br.readLine();
			while (line != null) { // null indicates end of file
				System.out.println(line);
				line = br.readLine(); 
			}

		} catch (FileNotFoundException fnfe) {
			System.out.println("File '" + fileName + "' does not exits");
		} catch (IOException ioe) {
			System.out.println("Error in reading");
		}
		
		System.out.println("Done");
		kbd.close();
	}
}
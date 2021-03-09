package inputoutput;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SumInt02 {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = kbd.nextLine();
		FileReader fr = null;
		BufferedReader br = null;
		
		try
		{
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			int total = 0;
			String line = br.readLine();
			while (line != null) // null indicates end of file
			{
				StringTokenizer st = new StringTokenizer(line, ",");
				while (st.hasMoreTokens()) {
					String aToken = st.nextToken();
					total += Integer.parseInt(aToken);
				}
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
		finally
		{
			try
			{
				if (fr != null)
					fr.close();
			}
			catch (IOException ioe)
			{
				System.out.println(ioe.getMessage());
			}
				
		}
	}
}


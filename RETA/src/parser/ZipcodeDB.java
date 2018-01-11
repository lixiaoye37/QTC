package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.ZipcodeInfo;

public class ZipcodeDB 
{
	private ArrayList<ZipcodeInfo> ListOfZipcode; 
	
	public ZipcodeDB(String FilePath) 
	{
		try 
		{
			Scanner input = new Scanner(new File(FilePath));
			ListOfZipcode = new ArrayList<>();
			
			// skip first line
			String line = input.nextLine();
			while(input.hasNext()) 
			{
				line = input.nextLine();
				if(!line.isEmpty()) 
				{
					String[] fields = line.split(",");
					String zipcode = fields[0];
					String city = fields[1];
					String state = fields[2];
					String latitude = fields[3];
					String longitude = fields[4];
					String timezone = fields[5];
					String dst = fields[6];
					
					ZipcodeInfo temp = new ZipcodeInfo(zipcode, city, state, latitude, longitude, timezone, dst);
					ListOfZipcode.add(temp);
				}
				
			}
			input.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("\nError with the file or incorrect location.");
			e.printStackTrace();
		}
	}
	
	public ArrayList<ZipcodeInfo> getListOfZipcode() {
		return ListOfZipcode;
	}
}

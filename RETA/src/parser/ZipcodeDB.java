package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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

	public class ZipcodeInfo
	{
		private String zipcode;
		private String city;
		private String state;
		private String latitude;
		private String longitude;
		private String timezone;
		private String dst;
		
		public ZipcodeInfo(String zipcode, String city, String state, String latitude, String longitude,
				String timezone, String dst) 
		{
			this.zipcode = zipcode;
			this.city = city;
			this.state = state;
			this.latitude = latitude;
			this.longitude = longitude;
			this.timezone = timezone;
			this.dst = dst;
		}

		public String getZipcode() {
			return zipcode;
		}

		public String getCity() {
			return city;
		}

		public String getState() {
			return state;
		}

		public String getLatitude() {
			return latitude;
		}

		public String getLongitude() {
			return longitude;
		}

		public String getTimezone() {
			return timezone;
		}

		public String getDst() {
			return dst;
		}
		
	}
}

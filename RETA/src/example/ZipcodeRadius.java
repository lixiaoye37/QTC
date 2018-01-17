package example;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.xml.sax.SAXException;

import model.Provider;
import model.ZipcodeInfo;
import parser.VaProviderNetwork;
import parser.ZipcodeDB;
import utils.Geolocation;
import utils.RadiusBox;

public class ZipcodeRadius {
	static final Double EarthRadiusInMiles = 3956.0;
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		
		ZipcodeDB ListOfZipcode = new ZipcodeDB("QTC files\\zipcode.csv");
		VaProviderNetwork vpNetwork = null;
		try 
		{
			vpNetwork = new VaProviderNetwork("QTC files\\VA Provider Network List.xlsx");
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SAXException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (OpenXML4JException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 91776, San Gabriel, CA
		double latitude = 34.089059;
		double longitude = -118.095;
		double radiusInMiles = 50.0;
		
		// The radiusBox object finds four ranges: top and bottom latitude ranges 
		// and left and right longitude ranges of a given point. 
		RadiusBox radiusBox = RadiusBox.create(latitude, longitude, radiusInMiles, EarthRadiusInMiles);
		
		// this for-loop finds all zipcode that are within the radius box
		// and puts it in the ZipcodeWithinRadius ArrayList
		// The reason why this is a radius "box" is because sql can only 
		// search longitude and latitude between min and max ranges and 
		// this loop simulates that
		// SQL query call
		ArrayList<ZipcodeInfo> ZipcodeWithinRadius = new ArrayList<>();
		for (ZipcodeInfo Info : ListOfZipcode.getListOfZipcode()) {
			boolean IsBetweenHoriRange = 
					radiusBox.getLeftLine() <= Double.parseDouble(Info.getLongitude()) && 
					radiusBox.getRightLine() >= Double.parseDouble(Info.getLongitude());

			boolean IsBetweenVertRange = 
					radiusBox.getTopLine() >= Double.parseDouble(Info.getLatitude()) && 
					radiusBox.getBottomLine() <= Double.parseDouble(Info.getLatitude());
		
			if (IsBetweenHoriRange && IsBetweenVertRange) {
				ZipcodeWithinRadius.add(Info);
			}
		}
		
		// Since we want zipcode within a radius, not a radius box, this for-loop 
		// checks all zipcodes inside the ZipcodeWithinRadius ArrayList to see if 
		// their distance is less than the radius.
		// if they are more than the radius, they get removed from the list
		// Servlet action
		for(int index = 0; index < ZipcodeWithinRadius.size(); index++) 
		{
			ZipcodeInfo info = ZipcodeWithinRadius.get(index);
			
			double InfoLat = Double.parseDouble(info.getLatitude());
			double InfoLong = Double.parseDouble(info.getLongitude()); 
			
			//[IMPORTANT]: do not use the cartesian's coordinate distance formula to find 
			// the distances between two latitude and longitude points.
			// USE THE Geolocation.haversine() METHOD. 
			// This method specifically works with calculation of two latitude and longitude points
			// latitude and longitude points and cartesian points work differently
			double distance = Geolocation.haversine(latitude, longitude, InfoLat, InfoLong, EarthRadiusInMiles);
			
			if(distance > radiusInMiles)
			{
				ZipcodeWithinRadius.remove(info);
				index--;
			}
		}

		// this for-loop finds the providers that has a zipcode that matches the zipcode in 
		// the ZipcodeWithinRadius ArrayList and 
		// adds the provider into the ProviderWithinRadius ArrayList.
		// this loop ensure that all providers found are in within the radius
		// sql query call 
		ArrayList<Provider> ProviderWithinRadius = new ArrayList<>();
		for(int i = 0; i < ZipcodeWithinRadius.size(); i++) 
		{
			ZipcodeInfo info = ZipcodeWithinRadius.get(i);
			for(Provider provider: vpNetwork.getListOfProvider()) 
			{
				//System.out.println(provider.getZipCode().length() + " " + info.getZipcode().length());
				if(info.getZipcode().equals(provider.getZipCode())) 
				{
					ProviderWithinRadius.add(provider);					
				}	
			}
		}
		
		
		// [NOTE] The ZipcodeWithinRadius ArrayList containers zipcodes in the US. However,
		// this does not mean that all zipcodes in the ArrayList are paired with a QTC 
		// providers.
		// This for-loop finds all zipcodes inside the ZipcodeWithinRadius ArrayList 
		// that are connected with a provider in the ProviderWithinRadius ArrayList.
		// if they are not, that zipcode is remove from the ZipcodeWithinRadius ArrayList.
		// servlet action
		for(int i = 0; i < ZipcodeWithinRadius.size(); i++) 
		{
			ZipcodeInfo info = ZipcodeWithinRadius.get(i);
			boolean IsInfoInsideProvider = false;
			for(Provider provider: ProviderWithinRadius) 
			{
				//System.out.println(provider.getZipCode().length() + " " + info.getZipcode().length());
				if(info.getZipcode().equals(provider.getZipCode())) 
				{
					IsInfoInsideProvider = true;
				}	
			}
			
			if(!IsInfoInsideProvider) 
			{
				ZipcodeWithinRadius.remove(info);
				i--;
			}
		}
		
		System.out.println("Provider within radius:");
		for(Provider provider: ProviderWithinRadius) 
		{
			System.out.println("\t" + provider.toString());
		}
		
		System.out.println();
		System.out.println("Zipcode within radius:");
		for(ZipcodeInfo info: ZipcodeWithinRadius) 
		{
			System.out.println("\t" + info.toString());
		}
		System.out.println("Complete");
	}
	
}
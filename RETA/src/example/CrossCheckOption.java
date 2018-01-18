package example;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.xml.sax.SAXException;

import parser.ERRA;
import parser.Referral;
import parser.VaProviderNetwork;
import parser.ZipcodeDB;

public class CrossCheckOption {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));

		String StartDate = "01/01/2017";
		String EndDate = "03/01/2017";
		String State = "CA";
		ZipcodeDB ListOfZipcode = new ZipcodeDB("QTC files\\zipcode.csv");
		ERRA erra = null;
		Referral referral = null;
		
		try {
			referral = new Referral("QTC files\\Sample referral data v2.xlsx");

			erra = new ERRA("QTC files\\Sample ERRA Data.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OpenXML4JException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

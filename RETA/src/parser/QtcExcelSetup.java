package parser;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.xml.sax.SAXException;

public class QtcExcelSetup 
{
	private ERRA erra = null;
	private Referral referral = null;
	private VaProviderNetwork vpNetwork = null;
	private ZipcodeDB ListOfZipcode = null;
	
	/*
	 * IMPORTANT NOTE: 
	 * 		This java file is not part of the RETA system. 
	 * 		This file is an example of how to setup the parsing module.
	 * 		However, feel free to make this file a part of the RETA system.
	 * */
	
	public QtcExcelSetup() 
	{
		try
		{
			/*
			 *NOTE
			 *	The strings below are RELATIVE file paths. 
			 *	Using System.out.println(System.getProperty("user.dir")),
			 *	it shows that the working directory starts at QTC//.
			 * */
			ListOfZipcode = new ZipcodeDB("RETA\\QTC files\\zipcode.csv");
			
			vpNetwork = new VaProviderNetwork("RETA\\QTC files\\VA Provider Network List.xlsx");
			
			referral = new Referral("RETA\\QTC files\\Sample referral data v2.xlsx");
			
			erra = new ERRA("RETA\\QTC files\\Sample ERRA Data.xlsx");
			
			System.out.println();
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
	}

	public ERRA getErra() {
		return erra;
	}

	public Referral getReferral() {
		return referral;
	}

	public VaProviderNetwork getVpNetwork() {
		return vpNetwork;
	}
}

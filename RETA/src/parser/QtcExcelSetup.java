package parser;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.xml.sax.SAXException;

public class QtcExcelSetup 
{
	private ERRA erra = null;
	private Referral referral = null;
	private VaProviderNetwork vpNetwork = null;
	
	public QtcExcelSetup() 
	{
		try
		{
			
			erra = new ERRA(
					"C:\\Users\\Philip Tran\\My Stuff\\Programming\\WorkStation\\java\\QTC\\RETA\\QTC files\\Sample ERRA Data.xlsx");
			
			referral = new Referral(
					"C:\\Users\\Philip Tran\\My Stuff\\Programming\\WorkStation\\java\\QTC\\RETA\\QTC files\\Sample referral data v2.xlsx");
			
			vpNetwork = new VaProviderNetwork(
					"C:\\Users\\Philip Tran\\My Stuff\\Programming\\WorkStation\\java\\QTC\\RETA\\QTC files\\VA Provider Network List_non VetFed_083117.xlsx");
			
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

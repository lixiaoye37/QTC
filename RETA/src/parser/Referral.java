package parser;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.xml.sax.SAXException;

public class Referral
{
	private ArrayList<Claimant> ListOfClaimants;
	
	public Referral(String FilePath) throws IOException, SAXException, OpenXML4JException
	{
		ListOfClaimants = new ArrayList<>();
		
		{
			File xlsxFile = new File(FilePath);
			OPCPackage pkg = OPCPackage.open(xlsxFile, PackageAccess.READ);
			XlsxParser parser = new XlsxParser(pkg, new ReferralHandler());
			parser.process();
			pkg.close();
		}
	}
	
	public ArrayList<Claimant> getListOfClaimants() {
		return ListOfClaimants;
	}

	public void setListOfClaimant(ArrayList<Claimant> listOfClaimant) {
		ListOfClaimants = listOfClaimant;
	}

	public class Claimant
	{
		private String State;
		private String ZipCode;
		private String Date;
		private String SpecialtyGroup;
		private int NumOfAppointment;
		
		public Claimant(){}
		
		public Claimant(String state, String zipCode, String date, String specialtyGroup, int numOfAppointment) {
			State = state;
			ZipCode = zipCode;
			Date = date;
			SpecialtyGroup = specialtyGroup;
			NumOfAppointment = numOfAppointment;
		}

		public String toString()
		{
			return State + "\t" + ZipCode + "\t" + Date + "\t" + SpecialtyGroup + "\t" + NumOfAppointment;
		}

		public String getState() {
			return State;
		}

		public String getZipCode() {
			return ZipCode;
		}

		public String getDate() {
			return Date;
		}

		public String getSpecialtyGroup() {
			return SpecialtyGroup;
		}

		public int getNumOfAppointment() {
			return NumOfAppointment;
		}
		
		
	}
	
	private class ReferralHandler implements SheetContentsHandler
	{
		SimpleDateFormat ExcelFormat = new SimpleDateFormat("dd-MMM-yyyy");
		SimpleDateFormat CurrentFormat = new SimpleDateFormat("MM/dd/20yy");
		
		Claimant TempClaimant;
		
		int CurrentColNum;
		boolean isFirstRow = true;

		@Override
		public void startRow(int RowNum)
		{
			//*[DEBUG]*/System.out.println("RowNum: " + RowNum);
			TempClaimant = null;
			CurrentColNum = 0;
		}

		@Override
		public void endRow(int RowNum)
		{
			if(TempClaimant != null)
			{
				ListOfClaimants.add(TempClaimant);
			}
			if(isFirstRow)
			{
				isFirstRow = false;	
			}
			//*[DEBUG]*/System.out.println("\n");
		}

		@Override
		public void cell(String CellReference, String FormattedValue, XSSFComment Comment)
		{
			String value = FormattedValue;
			
			if(!isFirstRow)
			{
				if(TempClaimant == null)
				{
					TempClaimant = new Claimant();
				}
				
				switch(CurrentColNum)
				{
					case 0:
					{
						TempClaimant.State = value;
					}
					break;

					case 1:
					{
						TempClaimant.ZipCode = value;
					}
					break;
					case 2:
					{
						try
						{
							Date ExcelDate = ExcelFormat.parse(value);
							value = CurrentFormat.format(ExcelDate);
							TempClaimant.Date = value;
						}
						catch (ParseException e)
						{
							e.printStackTrace();
						}
					}
					break;
					case 3:
					{
						TempClaimant.SpecialtyGroup = value;
					}
					break;
					
					case 4:
					{
						TempClaimant.NumOfAppointment = Integer.parseInt(value);
					}
					break;
				}
					
			}
			//*[DEBUG]*/System.out.print(value + "\t");
			CurrentColNum++;
		}

		@Override
		public void headerFooter(String text, boolean isHeader, String tagName){}
	}
}

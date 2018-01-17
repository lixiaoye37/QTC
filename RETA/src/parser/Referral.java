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

import model.Claimant;

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
						String state = value.trim();
						TempClaimant.setState(state);
					}
					break;

					case 1:
					{
						String zipcode = value.trim();
						TempClaimant.setZipCode(value);
					}
					break;
					case 2:
					{
						try
						{
							Date ExcelDate = ExcelFormat.parse(value);
							value = CurrentFormat.format(ExcelDate);
							TempClaimant.setDate(value);
						}
						catch (ParseException e)
						{
							e.printStackTrace();
						}
					}
					break;
					case 3:
					{
						String SpecialtyGroup = value.trim();
						TempClaimant.setSpecialtyGroup(SpecialtyGroup);
					}
					break;
					
					case 4:
					{
						TempClaimant.setNumOfAppointment(Integer.parseInt(value));
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

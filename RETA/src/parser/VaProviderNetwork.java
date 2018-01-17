package parser;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.xml.sax.SAXException;

import model.Provider;

public class VaProviderNetwork
{
	private ArrayList<Provider> ListOfProvider;

	public VaProviderNetwork(String FilePath) throws IOException, SAXException, OpenXML4JException
	{
		ListOfProvider = new ArrayList<>();

		{
			File xlsxFile = new File(FilePath);
			OPCPackage pkg = OPCPackage.open(xlsxFile, PackageAccess.READ);
			XlsxParser parser = new XlsxParser(pkg, new VaProviderNetworkHandler());
			parser.process();
			pkg.close();
		}
	}

	public ArrayList<Provider> getListOfProvider() {
		return ListOfProvider;
	}

	private class VaProviderNetworkHandler implements SheetContentsHandler
	{
		Provider TempProvider;

		int CurrentColNum;
		boolean isFirstRow = true;

		@Override
		public void startRow(int RowNum)
		{
			// * [DEBUG] */System.out.println("RowNum: " + RowNum);
			TempProvider = null;
			CurrentColNum = 0;
		}

		@Override
		public void endRow(int RowNum)
		{
			if(TempProvider != null)
			{
				ListOfProvider.add(TempProvider);
			}
			if(isFirstRow)
			{
				isFirstRow = false;
			}
			// * [DEBUG] */System.out.println("\n");
		}

		@Override
		public void cell(String CellReference, String FormattedValue, XSSFComment Comment)
		{
			if(!isFirstRow)
			{
				if(TempProvider == null)
				{
					TempProvider = new Provider();
				}

				switch(CurrentColNum)
				{
					case 0:
					{
						TempProvider.setID(Integer.parseInt(FormattedValue));
					}
					break;

					case 1:
					{
						String specialty = FormattedValue.trim();
						TempProvider.setSpecialty(specialty);
					}
					break;
					case 2:
					{
						String state = FormattedValue.trim();
						TempProvider.setState(state);
					}
					break;
					case 3:
					{
						String zipcode = FormattedValue.trim();
						TempProvider.setZipCode(zipcode);
					}
					break;
				}

			}
			// * [DEBUG] */System.out.print(FormattedValue + "\t");

			CurrentColNum++;
		}

		@Override
		public void headerFooter(String text, boolean isHeader, String tagName){}
	}
}

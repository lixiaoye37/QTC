package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.xml.sax.SAXException;

import example.QtcExcelSetup;
import model.Specialty;
import parser.ERRA;
import parser.Referral;
import parser.ZipcodeDB;

@WebServlet("/Page/CrossCheck")
public class CrossCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ERRA erra = null;
	private Referral referral = null;
	
	public CrossCheck()
	{
		super();
	}
    
	public void init(ServletConfig config) throws ServletException 
    {
    	super.init(config);
    	
    	System.out.println(System.getProperty("user.dir"));
    	
		try 
		{
			referral = new Referral("RETA\\QTC files\\Sample referral data v2.xlsx");

			erra = new ERRA("RETA\\QTC files\\Sample ERRA Data.xlsx");
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
		
    	String[] StateList = new String[] {
				"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL",
				"GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA",
				"MA","MD","ME","MH","MI","MN","MO","MS","MT","NC",
				"ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR",
				"PA","PR","PW","RI","SC","SD","TN","TX","UT","VA",
				"VI","VT","WA","WI","WV","WY"};
		getServletContext().setAttribute("StateList", StateList);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("/Page/CrossCheck.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//String zipcode = request.getParameter("zipcodeQuery");
		//System.out.println(zipcode);
		
		String StartDate = "01/01/2017";
		String EndDate = "03/01/2017";
		String State = "CA";
		
		for(String date: getDatesBetweenRange(StartDate, EndDate)) 
		{
			if(erra.getTimeSchedule().containsKey(date)) 
			{
				System.out.println(date);
			}
		}
		
		request.getRequestDispatcher("/Page/CrossCheck.jsp").forward(request, response);
	}
	
	public static ArrayList<String> getDatesBetweenRange(String StartDate, String EndDate) 
	{
		String[] StartDateMDY = StartDate.split("/");
		int StartingYear = Integer.parseInt(StartDateMDY[2]);
		int StartingMonth = Integer.parseInt(StartDateMDY[0]);
		int StartingDay = Integer.parseInt(StartDateMDY[1]);
		Calendar calendar = new GregorianCalendar();
	    calendar.set(StartingYear, StartingMonth - 1, StartingDay);
	    
	    
	    String[] EndDateMDY = EndDate.split("/");
	    int EndingYear = Integer.parseInt(EndDateMDY[2]);
		int EndingMonth = Integer.parseInt(EndDateMDY[0]);
		int EndingDay = Integer.parseInt(EndDateMDY[1]);
		Calendar endCalendar = new GregorianCalendar();
	    endCalendar.set(EndingYear, EndingMonth - 1, EndingDay);

	    ArrayList<String> DatesBetweenRange = new ArrayList<>();
	    SimpleDateFormat DateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	    while (calendar.before(endCalendar))
	    {
	        Date result = calendar.getTime();
	        String formattedDate = DateFormatter.format(result);
	        DatesBetweenRange.add(formattedDate);
	        calendar.add(Calendar.DATE, 1);
	    }
	    Date result = endCalendar.getTime();
        String formattedDate = DateFormatter.format(result);
        DatesBetweenRange.add(formattedDate);
	    return DatesBetweenRange;
	}
}

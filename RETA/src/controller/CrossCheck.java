package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.QtcExcelSetup;
import model.Specialty;

@WebServlet("/Page/CrossCheck")
public class CrossCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public CrossCheck()
	{
		super();
	}
    
	public void init(ServletConfig config) throws ServletException 
    {
    	super.init(config);
    	
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String[] StateList = new String[] {
				"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL",
				"GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA",
				"MA","MD","ME","MH","MI","MN","MO","MS","MT","NC",
				"ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR",
				"PA","PR","PW","RI","SC","SD","TN","TX","UT","VA",
				"VI","VT","WA","WI","WV","WY"};
		getServletContext().setAttribute("StateList", StateList);
		System.out.println(StateList);
    	
		request.getRequestDispatcher("/Page/crossCheck.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String zipcode = request.getParameter("zipcodeQuery");
		System.out.println(zipcode);
		String state = request.getParameter("StateList");
		System.out.println(state);
		request.getRequestDispatcher("/Page/crossCheck.jsp").forward(request, response);
	}
}

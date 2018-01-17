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
		request.getRequestDispatcher("/Page/CrossCheck.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String zipcode = request.getParameter("zipcodeQuery");
		System.out.println(zipcode);
		String state = request.getParameter("StateList");
		System.out.println(state);
		request.getRequestDispatcher("/Page/CrossCheck.jsp").forward(request, response);
	}
}

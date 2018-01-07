package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Specialty;
import parser.QtcExcelSetup;

@WebServlet("/Page/CheckoutSpecialtyList")
public class CheckoutSpecialtyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckoutSpecialtyList() 
    {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException 
    {
    	super.init(config);
		
    	ArrayList<Specialty> specialties = new ArrayList<Specialty>();
    	
		specialties.add(new Specialty("AUD",100));
		specialties.add(new Specialty("NEU",100));
		specialties.add(new Specialty("CAR",100));
		specialties.add(new Specialty("OPH",100));
		specialties.add(new Specialty("DEN",100));
		specialties.add(new Specialty("DER",100));
		specialties.add(new Specialty("GEN",50));
		specialties.add(new Specialty("GYN",100));
		specialties.add(new Specialty("GAS",100));
		specialties.add(new Specialty("NES",100));

		getServletContext().setAttribute("specialties", specialties);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("/Page/CheckboxSpecialtyListView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<Specialty> specialties = (ArrayList<Specialty>) getServletContext().getAttribute("specialties");
		String[] CheckedSpecialties = request.getParameterValues("specialty");
		
	}

}

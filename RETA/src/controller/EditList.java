package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Specialty;
//import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
//import org.xml.sax.SAXException;

//import java.io.PrintWriter;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Connection;
//import java.sql.Statement;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Page/Main")
public class EditList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session;
		ArrayList<Specialty> specialties = new ArrayList<Specialty>();
		
		Specialty spe1 = new Specialty("AUD",100);
		specialties.add(spe1);
		
		Specialty spe2 = new Specialty("NEU",100);
		specialties.add(spe2);
		
		Specialty spe3 = new Specialty("CAR",100);
		specialties.add(spe3);
		
		Specialty spe4 = new Specialty("OPH",100);
		specialties.add(spe4);
		
		Specialty spe5 = new Specialty("DEN",100);
		specialties.add(spe5);
		
		Specialty spe6 = new Specialty("DER",100);
		specialties.add(spe6);
		
		Specialty spe7 = new Specialty("GEN",50);
		specialties.add(spe7);
		
		Specialty spe8 = new Specialty("GYN",100);
		specialties.add(spe8);
		
		Specialty spe9 = new Specialty("GAS",100);
		specialties.add(spe9);
	
		Specialty spe10 = new Specialty("NES",100);
		specialties.add(spe10);
		
		session = request.getSession();
		
		
		session.setAttribute("specialties", specialties);
//		if(request.getParameter("add")!=null) {
//			int status = Integer.parseInt(request.getParameter("add"));
//			
//			if(status==0) {
//				submit(session,request,specialties);
//			}else if(status == 1) {
//				add(session);
//			}
//		}

		request.getRequestDispatcher("/Page/ListEditView.jsp").forward(request, response);

	}
	
	

	private void submit(HttpSession session, HttpServletRequest request, ArrayList<Specialty> specialties) {
		// TODO Auto-generated method stub
		//String click = (String) session.getAttribute("click");
		String name = (String)request.getParameter("name");
		int radius = Integer.parseInt((String)request.getParameter("radius"));
		Specialty newSpec = new Specialty(name,radius);
		specialties.add(newSpec);
		session.setAttribute("specialties", specialties);
		int click = 0;
		session.setAttribute("click", click);
		
	}
	
	private void add(HttpSession session) {
		
		int click = 1;
		session.setAttribute("click",click);
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	

}

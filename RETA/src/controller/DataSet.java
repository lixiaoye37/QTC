package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.xml.sax.SAXException;

import parser.ERRA;
import parser.Referral;
import parser.VaProviderNetwork;

/**
 * Servlet implementation class DataSet
 */
@WebServlet("/Page/DataSet")
public class DataSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		// TODO Auto-generated method stub
				ERRA erra = null;
				Referral referral = null;
				VaProviderNetwork vpNetwork = null;
				try
				{
					// using default paths
					erra = new ERRA(
							"C:\\Users\\limas\\Desktop\\QTC\\Sample ERRA Data.xlsx");
					referral = new Referral(
							"C:\\Users\\limas\\Desktop\\QTC\\Sample referral data v2.xlsx");
					vpNetwork = new VaProviderNetwork(
							"C:\\Users\\limas\\Desktop\\QTC\\VA Provider Network List_non VetFed_083117.xlsx");
					
				}
				catch (IOException e)
				{
					out.println("<h1> something went wrong </h1>");
					e.printStackTrace();
				}
				catch (SAXException e)
				{
					e.printStackTrace();
				}
				catch (OpenXML4JException e)
				{
					e.printStackTrace();
				}
				
//				HttpSession session = request.getSession();;
				
				//out.println("<h1>"+erra.getLocationHistory()+ "</h1>");
//				out.println("<h1>"+erra.getDate_time().get(0).toString() + "</h1>");
//				out.println(referral.getListOfClaimant() +" : <h1> gus it worked but the string looks weird</h1>"); //displays the list of referrals
//				out.println("<h1>"+vpNetwork.getListOfProvider()+"</h1>"); //displays the list of Providers
//				session.setAttribute("erra", erra.toString());
//				session.setAttribute("", referral);
//			session.setAttribute("", vpNetwork);
//				request.getRequestDispatcher("/Page/crossCheck.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

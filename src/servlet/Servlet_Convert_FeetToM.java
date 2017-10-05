package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clientToSOAPws.SOAPwsClient_convert;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet_convert")
public class Servlet_Convert_FeetToM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Convert_FeetToM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String lengthMeters = "-1.0";
		SOAPwsClient_convert client = new SOAPwsClient_convert();
		String runwayLengthFeet = request.getParameter("runwayLengthFeet"); 
		PrintWriter out = response.getWriter();
		System.out.println(runwayLengthFeet);
		if(runwayLengthFeet == null || runwayLengthFeet.equals("")){
			out.write("Illegal length parameter");
			response.setStatus(400); // 400=bad request 
		}else{
			try {
				lengthMeters = client.sendRequest(runwayLengthFeet);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(lengthMeters + " m");
			response.sendRedirect("/getKilometers?runwayLengthMeters=" + lengthMeters);
		}
		

		
		
	}

}

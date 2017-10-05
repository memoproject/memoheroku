package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myServClient.MyServClient;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet_MyConvert")
public class Servlet_MyConvert_MtoKm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_MyConvert_MtoKm() {
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
	
		
		MyServClient client = new MyServClient();
		String runwayLengthMeters = request.getParameter("runwayLengthMeters");
		PrintWriter out = response.getWriter();

		if(runwayLengthMeters == null || runwayLengthMeters.equals("")){
			out.write("Illegal length parameter");
			response.setStatus(400); // 400=bad request 
		}else{
			try {
				out.write("" + client.sendRequest(Double.parseDouble(runwayLengthMeters)) + " km"); 		
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

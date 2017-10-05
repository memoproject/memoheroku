package servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import clientToSOAPws.SOAPwsClient_airportData;


/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet_airportData")
public class Servlet_AirportData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_AirportData() {
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

		double lengthFeet=0.0;
		String xml = "";
		SOAPwsClient_airportData client = new SOAPwsClient_airportData();
		String airportCode = request.getParameter("airportCode"); 
		PrintWriter out = response.getWriter();
		if(airportCode == null || airportCode.equals("")){
			out.write("Airport not found!");
			response.setStatus(400); // 400=bad request  
		}else{
		
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = null;
			try {
			    builder = factory.newDocumentBuilder(); //XML Builder
			} catch (ParserConfigurationException e) {
			    e.printStackTrace();  
			}
			
			try {
				xml = client.sendRequest(airportCode); // SOAP XML RESP!
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			try {
				//Creates XML-document
				org.w3c.dom.Document xmlDocument = builder.parse(new ByteArrayInputStream(xml.getBytes()));
				javax.xml.xpath.XPath xPath =  XPathFactory.newInstance().newXPath();
				
				//Parse feet from airport XML data
				lengthFeet = Double.parseDouble(xPath.compile("/NewDataSet/Table/RunwayLengthFeet").evaluate(xmlDocument));
			} catch (XPathExpressionException | org.xml.sax.SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}
			//System.out.println(lengthFeet + " feet");
			response.sendRedirect("/getMeters?runwayLengthFeet="+lengthFeet);
		}
	}

}

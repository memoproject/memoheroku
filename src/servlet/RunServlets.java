/* classname RunServlets
 * Run MyServ.java on server
 * Run RunServlets as a java application
 * use postman / browser  testi
 */

package servlet;

import javax.servlet.annotation.WebListener;
import javax.xml.ws.Endpoint;

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
//import org.eclipse.jetty.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.webapp.WebAppContext;

import myServ.MyServ;

//@WebListener
public class RunServlets {
	// for local computer service
	//static Integer port = 8888;
	//static Integer port = Integer.valueOf(System.getenv("PORT"));
	public static void main(String[] args) throws Exception {
		ServletHandler handler = new ServletHandler();
		// add all servlet to use to the handler, the second argument is the
		// path (e.g. http://localhost:8080/searchPublication)
		// handler.addServletWithMapping(SearchPublication.class,
		// "/searchPublication");
		// handler.addServletWithMapping(UserProfile.class, "/getProfile");
		// handler.addServletWithMapping(CreateUserProfile.class,
		// "/createProfile");
		// handler.addServlet(holder);
		// Create a new Server, add the handler to it and start
		handler.addServletWithMapping(Servlet_AirportData.class, "/getAirportData");
		handler.addServletWithMapping(Servlet_Convert_FeetToM.class, "/getMeters");
		handler.addServletWithMapping(Servlet_MyConvert_MtoKm.class, "/getKilometers");
		
		// for local computerservice
		//Server server = new Server(8888); 
		
		Integer port;
		
		//for heroku
		//port = Integer.valueOf(System.getenv("PORT"));
		try {
			if (Integer.valueOf(System.getenv("PORT")) != null) {
				port = Integer.valueOf(System.getenv("PORT"));
			}
			else {
				port = Integer.valueOf(8888);
			}
		} catch (NumberFormatException ex) {
			port = Integer.valueOf(8888);
		}
		System.out.println(port);
		System.err.println(port);
		//Server server = null;
		String address = "http://0.0.0.0:"+port+"/";
		Endpoint.publish(address, new MyServ());
		Server server = new Server(port); //port.intValue()
			//ServerConnector http = new ServerConnector(server, new HttpConnectionFactory(new HttpConfiguration()));
			//http.setPort(port);
			//http.setIdleTimeout(Integer.MAX_VALUE);
		    
			//server.setConnectors(http);
			/*server.setHandler(handler);
			server.start();
			// this dumps a lot of debug output to the console.
			server.dumpStdErr();
			server.join();
			//LOGGER.log(Level.INFO, "Starting jetty on port: {0}", port);
			String address = "http://0.0.0.0:"+port+"/";
			Endpoint.publish(address, new MyServ());*/
			
			
			
	
		
		server.setHandler(handler);
		
		//heroku
		
		//LOGGER.log(Level.INFO, "Starting jetty on port: {0}", port);
		//System.err.println("porttinro: " + RunServlets.port);
		
		//final WebAppContext root = new WebAppContext();
		//root.setContextPath("/");
		//root.setParentLoaderPriority(true);
		
	    //final String webappDirLocation = "src/myServ/MyServ/";
        //root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        //root.setResourceBase(webappDirLocation);
		//
		
		server.start();
		// this dumps a lot of debug output to the console.
		server.dumpStdErr();
		server.join();
		//LOGGER.log(Level.INFO, "Starting jetty on port: {0}", port);
	
		
	}
}

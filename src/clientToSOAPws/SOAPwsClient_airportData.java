package clientToSOAPws;

import java.io.IOException;
import java.net.URISyntaxException;

import net.webservicex_airportData.Airport;
import net.webservicex_airportData.AirportSoap;

public class SOAPwsClient_airportData {

	public SOAPwsClient_airportData(){}
	
	public String sendRequest(String airportCode) throws URISyntaxException, IOException {	
	
		String code = airportCode;
		Airport airportService = new Airport();
		AirportSoap airportServiceSoap = airportService.getAirportSoap();
		String airportInfo = airportServiceSoap.getAirportInformationByAirportCode(code);
		
		//System.out.println(airportInfo);
		return "" + airportInfo; 
	
	}
	
}

package clientToSOAPws;

import java.io.IOException;
import java.net.URISyntaxException;

import net.webservicex_convert_FeetToM.LengthUnit;
import net.webservicex_convert_FeetToM.LengthUnitSoap;
import net.webservicex_convert_FeetToM.Lengths;

public class SOAPwsClient_convert {

	public SOAPwsClient_convert(){}
	
	public String sendRequest(String runwayLengthFeet) throws URISyntaxException, IOException {	
	
		Double length = Double.parseDouble(runwayLengthFeet);
		LengthUnit lengthUnitService = new LengthUnit();
		LengthUnitSoap lengthUnitServiceSoap = lengthUnitService.getLengthUnitSoap();
		Double lengthMeters = lengthUnitServiceSoap.changeLengthUnit(length, Lengths.FEET, Lengths.METERS);

		//System.out.println(lengthMeters);
		return "" + lengthMeters;
	
	}
	
}

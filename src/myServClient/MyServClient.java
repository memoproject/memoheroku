/**
 * 
 */
package myServClient;

import java.io.IOException;
import java.net.URISyntaxException;

import net.Myservice_convert_MtoKM.*;

/**
 * @author 
 *
 */
public class MyServClient {

	public MyServClient(){}
	
	public double sendRequest(double meters) throws URISyntaxException, IOException {	
	
		double m = meters;
		MyServService myClient = new MyServService();
		MyServ myServSoap = myClient.getMyServPort();
		double km = myServSoap.convertMtoKm(m); 
		//System.out.println(km);
		return km; 
	
	}

}

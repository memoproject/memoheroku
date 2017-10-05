/**
 * 
 */
package myServ;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlType;

/**
 * @author 
 *
 */

@WebService (targetNamespace="http://myServOriginal") 
@XmlType(namespace="test1", name = "InfoSource", propOrder = { "infoSource" }) 
public class MyServ {

	@WebMethod
	public double ConvertMtoKm(double meters) {
		double km = meters / 1000;
		return km;
	}

}

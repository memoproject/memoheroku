
package net.Myservice_convert_MtoKM;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the myserv package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConvertMtoKmResponse_QNAME = new QName("http://myServa", "ConvertMtoKmResponse");
    private final static QName _ConvertMtoKm_QNAME = new QName("http://myServa", "ConvertMtoKm");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: myserv
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConvertMtoKm }
     * 
     */
    public ConvertMtoKm createConvertMtoKm() {
        return new ConvertMtoKm();
    }

    /**
     * Create an instance of {@link ConvertMtoKmResponse }
     * 
     */
    public ConvertMtoKmResponse createConvertMtoKmResponse() {
        return new ConvertMtoKmResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertMtoKmResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myServ", name = "ConvertMtoKmResponse")
    public JAXBElement<ConvertMtoKmResponse> createConvertMtoKmResponse(ConvertMtoKmResponse value) {
        return new JAXBElement<ConvertMtoKmResponse>(_ConvertMtoKmResponse_QNAME, ConvertMtoKmResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertMtoKm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myServ", name = "ConvertMtoKm")
    public JAXBElement<ConvertMtoKm> createConvertMtoKm(ConvertMtoKm value) {
        return new JAXBElement<ConvertMtoKm>(_ConvertMtoKm_QNAME, ConvertMtoKm.class, null, value);
    }

}

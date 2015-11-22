
package notenservice.wsexport;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "NotenServiceService", targetNamespace = "http://ws.notenservice/", wsdlLocation = "http://localhost:9999/notenservice?wsdl")
public class NotenServiceService
    extends Service
{

    private final static URL NOTENSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException NOTENSERVICESERVICE_EXCEPTION;
    private final static QName NOTENSERVICESERVICE_QNAME = new QName("http://ws.notenservice/", "NotenServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9999/notenservice?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NOTENSERVICESERVICE_WSDL_LOCATION = url;
        NOTENSERVICESERVICE_EXCEPTION = e;
    }

    public NotenServiceService() {
        super(__getWsdlLocation(), NOTENSERVICESERVICE_QNAME);
    }

    public NotenServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), NOTENSERVICESERVICE_QNAME, features);
    }

    public NotenServiceService(URL wsdlLocation) {
        super(wsdlLocation, NOTENSERVICESERVICE_QNAME);
    }

    public NotenServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NOTENSERVICESERVICE_QNAME, features);
    }

    public NotenServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NotenServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns NotenService
     */
    @WebEndpoint(name = "NotenServicePort")
    public NotenService getNotenServicePort() {
        return super.getPort(new QName("http://ws.notenservice/", "NotenServicePort"), NotenService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NotenService
     */
    @WebEndpoint(name = "NotenServicePort")
    public NotenService getNotenServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.notenservice/", "NotenServicePort"), NotenService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NOTENSERVICESERVICE_EXCEPTION!= null) {
            throw NOTENSERVICESERVICE_EXCEPTION;
        }
        return NOTENSERVICESERVICE_WSDL_LOCATION;
    }

}
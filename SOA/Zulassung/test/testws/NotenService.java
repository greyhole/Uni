
package test.testws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "NotenService", targetNamespace = "http://ws.test/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface NotenService {


    /**
     * 
     * @param arg0
     * @return
     *     returns test.testws.Studentenliste
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://ws.test/NotenService/getMarksRequest", output = "http://ws.test/NotenService/getMarksResponse")
    public Studentenliste getMarks(
        @WebParam(name = "arg0", partName = "arg0")
        Studentenliste arg0);

}

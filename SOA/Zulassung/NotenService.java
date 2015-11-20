package test.ws;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import test.ws.*;

@WebService(name="NotenService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class NotenService
{

    @WebMethod
    public Studentenliste getMarks (Studentenliste list)
    {
        return list;   
    }
}

package notenservice.ws;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import notenservice.ws.*;

@WebService(name="NotenService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class NotenService
{

    @WebMethod
    public Notenliste getMarks (Punkteliste pList, Notenskala nSkal)
    {
        Notenliste nList = new Notenliste();
        nSkal.sort();
        for(Student stu : pList.getPunkteliste()){
            //System.out.printf( "Note: %f\n", skal.getNote(stu.getPunkte()));
            nList.addResult(stu, nSkal.getNote(stu.getPunkte()));
        }
        return nList;
    }
}

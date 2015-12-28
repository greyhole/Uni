
package notenservice.ws;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import notenservice.ws.*;

@XmlRootElement
public class Punkteliste
{
    private ArrayList<Student> pList;

    public Punkteliste()
    {
    }
    
    public ArrayList<Student> getPunkteliste()
    {
        return pList;
    }
    
    public void setPunkteliste(ArrayList<Student> pList)
    {
        this.pList = pList;
    }
}

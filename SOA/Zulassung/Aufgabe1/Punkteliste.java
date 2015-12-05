
package notenservice.ws;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import notenservice.ws.*;

@XmlRootElement
public class Punkteliste
{
    private ArrayList<Student> punkte;

    public Punkteliste()
    {
    }
    
    public ArrayList<Student> getPunkteliste()
    {
        return this.punkte;
    }
    
    public void setPunkteliste(ArrayList<Student> punkte)
    {
        this.punkte = punkte;
    }
}

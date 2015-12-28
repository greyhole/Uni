
package notenservice.ws;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import notenservice.ws.*;

@XmlRootElement
public class Notenskala
{
    private ArrayList<Notenwert> noten;

    public Notenskala()
    {
    }
    
    public ArrayList<Notenwert> getNotenskala()
    {
        return this.noten;
    }
    
    public void setNotenskala(ArrayList<Notenwert> noten)
    {
        this.noten = noten;
    }

    public void sort()
    {
        Collections.sort(noten);
    }

    public double getNote(double punkte)
    {
        double ret = 0;
        for (Notenwert note : noten){
           if (note.isNote(punkte)){
                ret = note.getNote();
           }
           else break;
        }
        return ret;
    }
}

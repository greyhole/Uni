
package notenservice.ws;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import notenservice.ws.*;

@XmlRootElement
public class Notenliste
{
    private ArrayList<StudentResult> list;

    public Notenliste()
    {
        list = new ArrayList<StudentResult>();
    }
    
    public ArrayList<StudentResult> getNotenliste()
    {
        return list;
    }
    
    public void setNotenliste(ArrayList<StudentResult> list)
    {
        this.list = list;
    }

    public void addResult(Student stu, double note)
    {
        StudentResult tmp = new StudentResult(stu.getMatrikel(), stu.getPunkte(), note);
        list.add(tmp);
    }
}

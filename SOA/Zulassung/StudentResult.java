package notenservice.ws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentResult extends Student
{
    private double note;

    public StudentResult()
    {
        super();
    }

    public StudentResult(int matrikel, double punkte, double note)
    {
        super(matrikel, punkte);
        this.note = note;
    }

    public void setNote (double note)
    {
        this.note = note;
    }

    public double getNote ()
    {
        return note;
    }
}

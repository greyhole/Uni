package notenservice.ws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student
{
    private int matrikel;
    private double punkte;

    public Student()
    {
    }

    public Student(int matrikel, double punkte)
    {
        this.matrikel = matrikel;
        this.punkte = punkte;
    }

    public void setPunkte (double punkte)
    {
        this.punkte = punkte;
    }

    public void setMatrikel (int matrikel)
    {
        this.matrikel = matrikel;
    }

    public double getPunkte ()
    {
        return punkte;
    }

    public int getMatrikel ()
    {
        return matrikel;
    }

}

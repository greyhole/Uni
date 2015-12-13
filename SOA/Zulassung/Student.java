package notenservice.ws;

public class Student
{
    private int matrikel;
    private double punkte;

    public Student()
    {
        this.matrikel = 0;
        this.punkte = -1;
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

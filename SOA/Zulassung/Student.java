package test.ws;

public class Student
{
    private int matrikel;
    private float punkte;
    private float note;;

    //public Student()
    //{
        //matrikel = 0;
        //punkte = -1;
        //note = -1;
    //}

    //public Student(int matrikel, float punkte)
    //{
        //this.matrikel = matrikel;
        //this.punkte = punkte;
        //note = -1;
    //}

    public void setStudent (int matrikel, float punkte)
    {
        this.matrikel = matrikel;
        this.punkte = punkte;
    }

    public void setNote (float note)
    {
        this.note = note;
    }

    public float getPunkte ()
    {
        return this.punkte;
    }

    public int getMatrikel ()
    {
        return this.matrikel;
    }
}

package notenservice.ws;

public class StudentResult extends Student
{
    private double note;

    public StudentResult()
    {
        super();
        this.note = 0;
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

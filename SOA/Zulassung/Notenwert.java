package test.ws;

public class Notenwert
{
    private float punkte;
    private float note;

    public Notenwert()
    {
        punkte = -1;
        note = -1;
    }

    public void setNotenwert (float note, float punkte)
    {
        this.punkte = punkte;
        this.note = note;
    }

    public float getNote ()
    {
        return this.note;
    }

    public float getPunkte ()
    {
        return this.punkte;
    }

    public boolean isNote (float punkte)
    {
        return this.punkte < punkte;
    }
}

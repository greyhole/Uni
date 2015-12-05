package notenservice.ws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Notenwert implements Comparable<Notenwert>
{
    
    private double punkte;
    private double note;

    public Notenwert()
    {
    }

    public double getNote ()
    {
        return this.note;
    }

    public double getPunkte ()
    {
        return this.punkte;
    }

    public void setNote (double note)
    {
        this.note = note;
    }

    public void setPunkte (double punkte)
    {
        this.punkte = punkte;
    }

    public boolean isNote (double punkte)
    {
        return this.punkte <= punkte;
    }

    @Override
    public int compareTo(Notenwert input)
    {
        return (this.note < input.getNote()) ? 1 : -1;
    }
}

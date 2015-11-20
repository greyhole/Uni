
package test.ws;

import java.util.ArrayList;
import test.ws.*;

public class Studentenliste
{
    private ArrayList<Student> studenten;

    public Studentenliste()
    {
        this.studenten = new ArrayList<Student>();
    }
    
    public void addStudent (int matrikel, float punkte)
    {
        Student tmp = new Student();
        tmp.setStudent(matrikel,punkte);
        this.studenten.add(tmp);
    }

    public Student getStudent (int index)
    {
        return this.studenten.get(index);
    }

    public float getMatrikel (int index)
    {
        return this.studenten.get(index).getMatrikel();
    }

    public ArrayList<Student> getStudentenliste()
    {
        return this.studenten;
    }
    
    public void setStudentenliste(ArrayList<Student> studenten)
    {
        this.studenten = studenten;
    }
}

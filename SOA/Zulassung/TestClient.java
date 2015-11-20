package test.client;

import test.ws.Student;
import test.testws.*;

public class TestClient
{
    public static void main( String[] args )
    {   
        ObjectFactory nnn = new ObjectFactory();
        ArrayList mmm = nnn.createArrayList();
        //ArrayList gradeList = new ArrayList<Integer>();
        //Box tmp = new Box();
        Student sss = new Student();
        sss.setStudent(23,55);
        mmm.add(sss);
        //gradeList.add(12);
        //gradeList.add(98);
        //gradeList.add(790);
        //gradeList.add(869);
        //tmp.getTestList().;

        NotenService port = new NotenServiceService().getNotentServicePort();
        //System.out.printf( "Antwort1: %s", port.hello("Chris"));
        //tmp2 = port.getGrades(tmp);
    }
}

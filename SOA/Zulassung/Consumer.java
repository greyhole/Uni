package notenservice.consumer;

import notenservice.wsexport.*;

public class Consumer
{
    public static void main( String[] args )
    {   
        NotenService port = new NotenServiceService().getNotenServicePort();
        Student stu;
        Notenwert nWert;
        Notenliste nList;
        Notenskala nSkal = new Notenskala();
        Punkteliste pList = new Punkteliste();

        stu = new Student();
        stu.setMatrikel(78929);
        stu.setPunkte(57);
        pList.getPunkteliste().add(stu);

        stu = new Student();
        stu.setMatrikel(33434);
        stu.setPunkte(0);
        pList.getPunkteliste().add(stu);

        stu = new Student();
        stu.setMatrikel(35555);
        stu.setPunkte(90);
        pList.getPunkteliste().add(stu);

        nWert = new Notenwert();
        nWert.setNote(1);
        nWert.setPunkte(90);
        nSkal.getNotenskala().add(nWert);
        
        nWert = new Notenwert();
        nWert.setNote(1.3);
        nWert.setPunkte(85);
        nSkal.getNotenskala().add(nWert);

        nWert = new Notenwert();
        nWert.setNote(1.7);
        nWert.setPunkte(80);
        nSkal.getNotenskala().add(nWert);

        nWert = new Notenwert();
        nWert.setNote(3);
        nWert.setPunkte(60);
        nSkal.getNotenskala().add(nWert);
        
        nWert = new Notenwert();
        nWert.setNote(3.3);
        nWert.setPunkte(55);
        nSkal.getNotenskala().add(nWert);
        
        nWert = new Notenwert();
        nWert.setNote(3.7);
        nWert.setPunkte(50);
        nSkal.getNotenskala().add(nWert);
        
        nWert = new Notenwert();
        nWert.setNote(2);
        nWert.setPunkte(75);
        nSkal.getNotenskala().add(nWert);
        
        nWert = new Notenwert();
        nWert.setNote(5);
        nWert.setPunkte(0);
        nSkal.getNotenskala().add(nWert);

        nWert = new Notenwert();
        nWert.setNote(4);
        nWert.setPunkte(45);
        nSkal.getNotenskala().add(nWert);

        nList = port.getMarks(pList, nSkal);

        for(StudentResult stuR : nList.getNotenliste()){
            System.out.printf( "Matrikelnummer: %d, Punkte: %.1f, Note: %.1f\n", stuR.getMatrikel(), stuR.getPunkte(), stuR.getNote());
        }
    }
}

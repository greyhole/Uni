package notenstatus.consumer;

import notenstatus.ws.*;

public class Consumer
{
    public static void main( String[] args )
    {   
        Notenstatus port = new NotenstatusService().getNotenstatusPort();
        Notenliste nList = new Notenliste();
        Notenstatus_Type ns = new Notenstatus_Type();

        nList.getNotenliste().add(3.3);

        nList.getNotenliste().add(3.3);

        nList.getNotenliste().add(5.0);

        nList.getNotenliste().add(1.0);

        nList.getNotenliste().add(2.3);

        nList.getNotenliste().add(1.7);

        ns = port.getNotenstatus(nList);

        for(Note n : ns.getNotenspiegel()){
            System.out.printf( "Note: %.1f, Anzahl: %d\n", n.getNotenwert(), n.getAnzahl());
        }
        System.out.printf( "Durchschnitt: %.1f\n", ns.getDurchschnitt());

    }
}

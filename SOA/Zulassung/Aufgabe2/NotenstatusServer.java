package notenstatus.ws;

import notenstatus.ws.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.ArrayList;

@WebService(name = "Notenstatus", targetNamespace = "http://ws.notenstatus/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class NotenstatusServer implements Notenstatus
{
    private List<Note> addNote(List<Note> list, double note)
    {
        boolean flag = false;
        for( Note n : list){
            if( n.getNotenwert() == note){
                flag = true;
                n.setAnzahl( n.getAnzahl() + 1 );
            }
        }
        if (!flag){
            Note n = new Note();
            n.setNotenwert(note);
            n.setAnzahl(1);
            list.add(n);
        }
        return list;
    }

    public Notenstatus_Type getNotenstatus (Notenliste nList)
    {
        double note_d = 0;
        int note_count = 0;
        Notenstatus_Type ret = new Notenstatus_Type();
        List<Note> notensp = new ArrayList<Note>();
        
        for (double note : nList.getNotenliste()){
            note_count++;
            note_d += note;
            notensp = addNote(notensp, note);
        }

        ret.setDurchschnitt(note_d/note_count);
        ret.getNotenspiegel().addAll(notensp);
        return ret;
    }
}

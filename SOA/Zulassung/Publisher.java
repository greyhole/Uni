package test.pub;

import test.ws.*;
import javax.swing.JOptionPane;
import javax.xml.ws.Endpoint;

public class Publisher
{
    public static void main( String[] args )
    {
        Endpoint endpoint = Endpoint.publish( "http://localhost:9999/hello", new NotenService() );
        //endpoint.stop();
    }
}

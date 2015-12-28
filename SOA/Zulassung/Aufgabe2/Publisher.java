package notenstatus.pub;

import notenstatus.ws.*;
import javax.xml.ws.Endpoint;

public class Publisher
{
    public static void main( String[] args )
    {
        Endpoint endpoint = Endpoint.publish( "http://localhost:9999/notenstatus", new NotenstatusServer() );
    }
}

package notenservice.pub;

import notenservice.ws.*;
import javax.xml.ws.Endpoint;

public class Publisher
{
    public static void main( String[] args )
    {
        Endpoint endpoint = Endpoint.publish( "http://localhost:9999/notenservice", new NotenService() );
    }
}

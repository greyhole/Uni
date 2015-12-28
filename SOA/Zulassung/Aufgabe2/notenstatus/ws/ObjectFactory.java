
package notenstatus.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the notenstatus.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Notenliste_QNAME = new QName("http://ws.notenstatus/", "notenliste");
    private final static QName _Note_QNAME = new QName("http://ws.notenstatus/", "note");
    private final static QName _Notenstatus_QNAME = new QName("http://ws.notenstatus/", "notenstatus");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: notenstatus.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Notenliste }
     * 
     */
    public Notenliste createNotenliste() {
        return new Notenliste();
    }

    /**
     * Create an instance of {@link Notenstatus_Type }
     * 
     */
    public Notenstatus_Type createNotenstatus_Type() {
        return new Notenstatus_Type();
    }

    /**
     * Create an instance of {@link Note }
     * 
     */
    public Note createNote() {
        return new Note();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Notenliste }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.notenstatus/", name = "notenliste")
    public JAXBElement<Notenliste> createNotenliste(Notenliste value) {
        return new JAXBElement<Notenliste>(_Notenliste_QNAME, Notenliste.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Note }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.notenstatus/", name = "note")
    public JAXBElement<Note> createNote(Note value) {
        return new JAXBElement<Note>(_Note_QNAME, Note.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Notenstatus_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.notenstatus/", name = "notenstatus")
    public JAXBElement<Notenstatus_Type> createNotenstatus(Notenstatus_Type value) {
        return new JAXBElement<Notenstatus_Type>(_Notenstatus_QNAME, Notenstatus_Type.class, null, value);
    }

}

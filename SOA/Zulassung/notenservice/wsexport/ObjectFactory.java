
package notenservice.wsexport;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the notenservice.wsexport package. 
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

    private final static QName _Notenskala_QNAME = new QName("http://ws.notenservice/", "notenskala");
    private final static QName _Punkteliste_QNAME = new QName("http://ws.notenservice/", "punkteliste");
    private final static QName _Notenliste_QNAME = new QName("http://ws.notenservice/", "notenliste");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: notenservice.wsexport
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Punkteliste }
     * 
     */
    public Punkteliste createPunkteliste() {
        return new Punkteliste();
    }

    /**
     * Create an instance of {@link Notenskala }
     * 
     */
    public Notenskala createNotenskala() {
        return new Notenskala();
    }

    /**
     * Create an instance of {@link Notenliste }
     * 
     */
    public Notenliste createNotenliste() {
        return new Notenliste();
    }

    /**
     * Create an instance of {@link StudentResult }
     * 
     */
    public StudentResult createStudentResult() {
        return new StudentResult();
    }

    /**
     * Create an instance of {@link Notenwert }
     * 
     */
    public Notenwert createNotenwert() {
        return new Notenwert();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Notenskala }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.notenservice/", name = "notenskala")
    public JAXBElement<Notenskala> createNotenskala(Notenskala value) {
        return new JAXBElement<Notenskala>(_Notenskala_QNAME, Notenskala.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Punkteliste }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.notenservice/", name = "punkteliste")
    public JAXBElement<Punkteliste> createPunkteliste(Punkteliste value) {
        return new JAXBElement<Punkteliste>(_Punkteliste_QNAME, Punkteliste.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Notenliste }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.notenservice/", name = "notenliste")
    public JAXBElement<Notenliste> createNotenliste(Notenliste value) {
        return new JAXBElement<Notenliste>(_Notenliste_QNAME, Notenliste.class, null, value);
    }

}


package notenstatus.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for note complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="note">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="notenwert" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="anzahl" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "note", propOrder = {
    "notenwert",
    "anzahl"
})
public class Note {

    protected double notenwert;
    protected int anzahl;

    /**
     * Gets the value of the notenwert property.
     * 
     */
    public double getNotenwert() {
        return notenwert;
    }

    /**
     * Sets the value of the notenwert property.
     * 
     */
    public void setNotenwert(double value) {
        this.notenwert = value;
    }

    /**
     * Gets the value of the anzahl property.
     * 
     */
    public int getAnzahl() {
        return anzahl;
    }

    /**
     * Sets the value of the anzahl property.
     * 
     */
    public void setAnzahl(int value) {
        this.anzahl = value;
    }

}

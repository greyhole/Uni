
package notenservice.wsexport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for notenwert complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notenwert">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="punkte" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notenwert", propOrder = {
    "note",
    "punkte"
})
public class Notenwert {

    protected double note;
    protected double punkte;

    /**
     * Gets the value of the note property.
     * 
     */
    public double getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     */
    public void setNote(double value) {
        this.note = value;
    }

    /**
     * Gets the value of the punkte property.
     * 
     */
    public double getPunkte() {
        return punkte;
    }

    /**
     * Sets the value of the punkte property.
     * 
     */
    public void setPunkte(double value) {
        this.punkte = value;
    }

}

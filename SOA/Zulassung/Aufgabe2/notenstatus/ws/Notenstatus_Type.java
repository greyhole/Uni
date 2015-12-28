
package notenstatus.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for notenstatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notenstatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="notenspiegel" type="{http://ws.notenstatus/}note" maxOccurs="unbounded"/>
 *         &lt;element name="durchschnitt" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notenstatus", propOrder = {
    "notenspiegel",
    "durchschnitt"
})
public class Notenstatus_Type {

    @XmlElement(required = true, nillable = true)
    protected List<Note> notenspiegel;
    protected double durchschnitt;

    /**
     * Gets the value of the notenspiegel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notenspiegel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotenspiegel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Note }
     * 
     * 
     */
    public List<Note> getNotenspiegel() {
        if (notenspiegel == null) {
            notenspiegel = new ArrayList<Note>();
        }
        return this.notenspiegel;
    }

    /**
     * Gets the value of the durchschnitt property.
     * 
     */
    public double getDurchschnitt() {
        return durchschnitt;
    }

    /**
     * Sets the value of the durchschnitt property.
     * 
     */
    public void setDurchschnitt(double value) {
        this.durchschnitt = value;
    }

}


package notenservice.wsexport;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for notenskala complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notenskala">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="notenskala" type="{http://ws.notenservice/}notenwert" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notenskala", propOrder = {
    "notenskala"
})
public class Notenskala {

    @XmlElement(nillable = true)
    protected List<Notenwert> notenskala;

    /**
     * Gets the value of the notenskala property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notenskala property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotenskala().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Notenwert }
     * 
     * 
     */
    public List<Notenwert> getNotenskala() {
        if (notenskala == null) {
            notenskala = new ArrayList<Notenwert>();
        }
        return this.notenskala;
    }

}

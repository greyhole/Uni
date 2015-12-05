
package notenservice.wsexport;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for notenliste complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notenliste">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="notenliste" type="{http://ws.notenservice/}studentResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notenliste", propOrder = {
    "notenliste"
})
public class Notenliste {

    @XmlElement(nillable = true)
    protected List<StudentResult> notenliste;

    /**
     * Gets the value of the notenliste property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notenliste property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotenliste().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StudentResult }
     * 
     * 
     */
    public List<StudentResult> getNotenliste() {
        if (notenliste == null) {
            notenliste = new ArrayList<StudentResult>();
        }
        return this.notenliste;
    }

}

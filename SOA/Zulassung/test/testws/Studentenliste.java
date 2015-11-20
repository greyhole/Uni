
package test.testws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for studentenliste complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="studentenliste">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="studentenliste" type="{http://ws.test/}student" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studentenliste", propOrder = {
    "studentenliste"
})
public class Studentenliste {

    @XmlElement(nillable = true)
    protected List<Student> studentenliste;

    /**
     * Gets the value of the studentenliste property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studentenliste property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudentenliste().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Student }
     * 
     * 
     */
    public List<Student> getStudentenliste() {
        if (studentenliste == null) {
            studentenliste = new ArrayList<Student>();
        }
        return this.studentenliste;
    }

}


package notenservice.wsexport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for studentResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="studentResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.notenservice/}student">
 *       &lt;sequence>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studentResult", propOrder = {
    "note"
})
public class StudentResult
    extends Student
{

    protected double note;

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

}

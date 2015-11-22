
package notenservice.wsexport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for student complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="student">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="matrikel" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "student", propOrder = {
    "matrikel",
    "punkte"
})
@XmlSeeAlso({
    StudentResult.class
})
public class Student {

    protected int matrikel;
    protected double punkte;

    /**
     * Gets the value of the matrikel property.
     * 
     */
    public int getMatrikel() {
        return matrikel;
    }

    /**
     * Sets the value of the matrikel property.
     * 
     */
    public void setMatrikel(int value) {
        this.matrikel = value;
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

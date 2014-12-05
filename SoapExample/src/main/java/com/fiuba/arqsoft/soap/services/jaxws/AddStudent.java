
package com.fiuba.arqsoft.soap.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "addSubject", namespace = "http://services.soap.arqsoft.fiuba.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addStudent", namespace = "http://services.soap.arqsoft.fiuba.com/", propOrder = {
    "studentID",
    "firstName",
    "lastName"
})
public class AddStudent {

    @XmlElement(name = "studentID", namespace = "")
    private String studentID;
    @XmlElement(name = "firstName", namespace = "")
    private String firstName;
    @XmlElement(name = "lastName", namespace = "")
    private String lastName;

    /**
     * 
     * @return
     *     returns String
     */
    public String getStudentID() {
        return this.studentID;
    }

    /**
     * 
     * @param studentID
     *     the value for the studentID property
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * 
     * @param firstName
     *     the value for the firstName property
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * 
     * @param lastName
     *     the value for the lastName property
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

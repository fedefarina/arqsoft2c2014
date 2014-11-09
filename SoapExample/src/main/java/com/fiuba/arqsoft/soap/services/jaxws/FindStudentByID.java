
package com.fiuba.arqsoft.soap.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findStudentByID", namespace = "http://services.soap.arqsoft.fiuba.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findStudentByID", namespace = "http://services.soap.arqsoft.fiuba.com/")
public class FindStudentByID {

    @XmlElement(name = "studentID", namespace = "")
    private String studentID;

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

}

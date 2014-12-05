
package com.fiuba.arqsoft.soap.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "addSubject", namespace = "http://services.soap.arqsoft.fiuba.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addSubject", namespace = "http://services.soap.arqsoft.fiuba.com/", propOrder = {
    "subjectCode",
    "name"
})
public class AddSubject {

    @XmlElement(name = "subjectCode", namespace = "")
    private String subjectCode;
    @XmlElement(name = "name", namespace = "")
    private String name;

    /**
     * 
     * @return
     *     returns String
     */
    public String getSubjectCode() {
        return this.subjectCode;
    }

    /**
     * 
     * @param subjectCode
     *     the value for the subjectCode property
     */
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @param name
     *     the value for the name property
     */
    public void setName(String name) {
        this.name = name;
    }

}

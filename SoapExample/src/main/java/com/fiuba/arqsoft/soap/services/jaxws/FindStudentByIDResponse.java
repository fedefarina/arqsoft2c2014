
package com.fiuba.arqsoft.soap.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fiuba.arqsoft.soap.domain.Student;

@XmlRootElement(name = "findStudentByIDResponse", namespace = "http://services.soap.arqsoft.fiuba.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findStudentByIDResponse", namespace = "http://services.soap.arqsoft.fiuba.com/")
public class FindStudentByIDResponse {

    @XmlElement(name = "return", namespace = "")
    private Student _return;

    /**
     * 
     * @return
     *     returns Student
     */
    public Student getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Student _return) {
        this._return = _return;
    }

}

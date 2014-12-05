
package com.fiuba.arqsoft.soap.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fiuba.arqsoft.soap.domain.Subject;

@XmlRootElement(name = "addSubjectResponse", namespace = "http://services.soap.arqsoft.fiuba.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addSubjectResponse", namespace = "http://services.soap.arqsoft.fiuba.com/")
public class AddSubjectResponse {

    @XmlElement(name = "return", namespace = "")
    private Subject _return;

    /**
     * 
     * @return
     *     returns Subject
     */
    public Subject getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Subject _return) {
        this._return = _return;
    }

}

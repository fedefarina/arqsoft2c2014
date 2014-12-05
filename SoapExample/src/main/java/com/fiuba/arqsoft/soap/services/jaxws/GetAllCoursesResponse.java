
package com.fiuba.arqsoft.soap.services.jaxws;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fiuba.arqsoft.soap.domain.Course;

@XmlRootElement(name = "getAllCoursesResponse", namespace = "http://services.soap.arqsoft.fiuba.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllCoursesResponse", namespace = "http://services.soap.arqsoft.fiuba.com/")
public class GetAllCoursesResponse {

    @XmlElement(name = "return", namespace = "")
    private Collection<Course> _return;

    /**
     * 
     * @return
     *     returns Collection<Course>
     */
    public Collection<Course> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Collection<Course> _return) {
        this._return = _return;
    }

}

package com.fiuba.arqsoft.soap.services.ws;

import com.fiuba.arqsoft.soap.dao.CourseDAO;
import com.fiuba.arqsoft.soap.domain.Course;
import com.fiuba.arqsoft.soap.services.CoursesManagement;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import java.util.Collection;

/**
 * Created by Fede on 12/5/14.
 */
@WebService(endpointInterface = "com.fiuba.arqsoft.soap.services.CoursesManagement",
        serviceName = "courses", targetNamespace = "http://com.aam.jaxws.server/")
@BindingType(value = "http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
public class CoursesWS implements CoursesManagement {

    CourseDAO courseDAO = new CourseDAO();

    public Collection<Course> getAllCourses() {
        return courseDAO.getAll();
    }
}

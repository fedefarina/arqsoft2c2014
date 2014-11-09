package com.fiuba.arqsoft.soap.services.ws;

import com.fiuba.arqsoft.soap.dao.Repository;
import com.fiuba.arqsoft.soap.domain.Student;
import com.fiuba.arqsoft.soap.exceptions.StudentNotFoundException;
import com.fiuba.arqsoft.soap.services.StudentsManagement;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Fede on 11/8/14.
 */


@WebService(endpointInterface = "com.fiuba.arqsoft.soap.services.StudentsManagement",
        serviceName = "StudentsWS", targetNamespace = "http://com.aam.jaxws.server/")
@BindingType(value = "http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
public class StudentsWS implements StudentsManagement {

    Map<String, Student> students = Repository.getAllStudents();

    static {
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");
    }

    public Student findStudentByID(String id) throws StudentNotFoundException {
        Student student = students.get(id);
        if (student != null)
            return student;
        throw new StudentNotFoundException();
    }


    public Student removeStudentByID(String id) throws StudentNotFoundException {
        Student student = students.get(id);
        if (student != null) {
            students.remove(id);
            return student;
        }
        throw new StudentNotFoundException();
    }


    public Collection<Student> getAllStudents() {
        return students.values();
    }
}

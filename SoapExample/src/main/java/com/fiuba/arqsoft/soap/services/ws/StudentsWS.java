package com.fiuba.arqsoft.soap.services.ws;

import com.fiuba.arqsoft.soap.domain.Student;
import com.fiuba.arqsoft.soap.exceptions.StudentNotFoundException;
import com.fiuba.arqsoft.soap.services.StudentsManagement;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fede on 11/8/14.
 */


@WebService(endpointInterface = "com.fiuba.arqsoft.soap.services.StudentsManagement",
        serviceName = "StudentsWS", targetNamespace = "http://com.aam.jaxws.server/")
@BindingType(value = "http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
public class StudentsWS implements StudentsManagement {


    private static Map<String, Student> students = new HashMap<String, Student>() {
        {
            put("90177", new Student("90177", "Federico", "Farina"));
        }

        {
            put("89009", new Student("89009", "Nicolas", "Icardi"));
        }
    };


    static {
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");
    }

    @Override
    public Student findStudentByID(String id) throws StudentNotFoundException {
        return null;
    }


    @Override
    public Collection<Student> getAllStudents() {
        return students.values();
    }
}

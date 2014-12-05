package com.fiuba.arqsoft.soap.services.ws;

import com.fiuba.arqsoft.soap.dao.Repository;
import com.fiuba.arqsoft.soap.dao.StudentsDAO;
import com.fiuba.arqsoft.soap.domain.Student;
import com.fiuba.arqsoft.soap.exceptions.StudentAlreadyExistException;
import com.fiuba.arqsoft.soap.exceptions.StudentNotFoundException;
import com.fiuba.arqsoft.soap.services.StudentsManagement;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import java.util.Collection;

/**
 * Created by Fede on 11/8/14.
 */


@WebService(endpointInterface = "com.fiuba.arqsoft.soap.services.StudentsManagement",
        serviceName = "students", targetNamespace = "http://com.aam.jaxws.server/")
@BindingType(value = "http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
public class StudentsWS implements StudentsManagement {

    StudentsDAO studentsDAO = new StudentsDAO();

    static {
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");
        Repository.initRepository();
    }

    public Student findStudentByID(String id) throws StudentNotFoundException {
        Student student = studentsDAO.getById(id);
        if (student != null)
            return student;
        throw new StudentNotFoundException();
    }


    public Student removeStudentByID(String id) throws StudentNotFoundException {
        Student student = studentsDAO.getById(id);
        if (student == null)
            throw new StudentNotFoundException();
        return studentsDAO.delete(id);
    }

    public Student addStudent(String id, String firstName, String lastName) throws StudentAlreadyExistException {
        Student student = studentsDAO.getById(id);
        if (student != null)
            throw new StudentAlreadyExistException();

        student = new Student(id, firstName, lastName);
        studentsDAO.addStudent(student);
        return student;
    }

    public Collection<Student> getAllStudents() {
        return studentsDAO.getAll();
    }
}

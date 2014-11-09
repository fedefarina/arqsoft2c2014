package com.fiuba.arqsoft.soap.services;


import com.fiuba.arqsoft.soap.domain.Student;
import com.fiuba.arqsoft.soap.exceptions.StudentNotFoundException;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Fede on 11/8/14.
 */

@WebService(name = "StudentsWS")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface StudentsManagement {

    public Student findStudentByID(@WebParam(name = "studentID") String id) throws StudentNotFoundException;

    public java.util.Collection<Student> getAllStudents();

}

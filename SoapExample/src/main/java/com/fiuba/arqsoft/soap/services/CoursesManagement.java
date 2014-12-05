package com.fiuba.arqsoft.soap.services;

import com.fiuba.arqsoft.soap.domain.Course;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Fede on 12/5/14.
 */
@WebService(name = "courses")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface CoursesManagement {
    public java.util.Collection<Course> getAllCourses();
}



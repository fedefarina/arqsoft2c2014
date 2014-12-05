package com.fiuba.arqsoft.soap.services.ws;

import com.fiuba.arqsoft.soap.dao.CourseDAO;
import com.fiuba.arqsoft.soap.dao.StudentsDAO;
import com.fiuba.arqsoft.soap.domain.Course;
import com.fiuba.arqsoft.soap.domain.Student;
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
    StudentsDAO studentsDAO = new StudentsDAO();

    public Collection<Course> getAllCourses() {
        return courseDAO.getAll();
    }

    public Course removeCourseByID(String id) throws Exception {
        Course course = courseDAO.getById(id);
        if (course == null)
            throw new Exception("Course not found");

        return courseDAO.delete(id);
    }

    public Course getCourseByID(String id) throws Exception {
        Course course = courseDAO.getById(id);
        if (course == null)
            throw new Exception("Course not found");
        return course;
    }

    public Course enrollInCourse(String courseID, String studentID) throws Exception {
        Course course = courseDAO.getById(courseID);
        if (course == null)
            throw new Exception("Course not found");
        Student student = studentsDAO.getById(studentID);
        if (student == null)
            throw new Exception("Student not found");
        courseDAO.addStudentToCourse(course, student);
        return course;
    }
}

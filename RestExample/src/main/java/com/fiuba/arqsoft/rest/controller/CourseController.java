package com.fiuba.arqsoft.rest.controller;

import com.fiuba.arqsoft.rest.dao.CourseDAO;
import com.fiuba.arqsoft.rest.dao.StudentsDAO;
import com.fiuba.arqsoft.rest.model.Course;
import com.fiuba.arqsoft.rest.model.Courses;
import com.fiuba.arqsoft.rest.model.Student;
import com.fiuba.arqsoft.rest.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Fede on 12/4/14.
 */
@Controller
public class CourseController {

    private CourseDAO courseDAO;
    private StudentsDAO studentsDAO;

    @Autowired
    public CourseController(CourseDAO courseDAO, StudentsDAO studentsDAO) {
        this.courseDAO = courseDAO;
        this.studentsDAO = studentsDAO;
    }

    @RequestMapping(value = "/courses/{courseID}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Course> getByID(@PathVariable("courseID") String courseID) {
        Course course = courseDAO.getById(courseID);
        course.removeLinks();
        for (Student student : course.getStudents()) {
            student.removeLinks();
            student.add(linkTo(methodOn(StudentsController.class).getByID(student.getStudentID())).withSelfRel());
        }
        course.add(linkTo(methodOn(CourseController.class).getByID(courseID)).withSelfRel());
        course.add(linkTo(methodOn(SubjectController.class).getByID(course.getSubjectID())).withRel("subject"));
        return new ResponseEntity<>(course, HttpStatus.OK);
    }


    @RequestMapping(value = "/courses/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Courses> getAllCourses() {
        Courses courses = new Courses(courseDAO.getAll());
        for (Course course : courses.getCourses()) {
            String courseID = course.getCourseID();
            List<Student> students = course.getStudents();
            for (Student student : students) {
                student.removeLinks();
                student.add(linkTo(methodOn(StudentsController.class).getByID(student.getStudentID())).withSelfRel());
            }
            course.removeLinks();
            course.add(linkTo(methodOn(SubjectController.class).getByID(course.getSubjectID())).withRel("subject"));
            course.add(linkTo(methodOn(CourseController.class).getByID(courseID)).withSelfRel());
        }
        courses.add(linkTo(methodOn(CourseController.class).getAllCourses()).withSelfRel());
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/courses/{courseID}/students", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Student> enrollStudent(@PathVariable("courseID") String courseID,
                                                 @RequestBody Student student) throws Exception {

        Course course = courseDAO.getById(courseID);
        if (course == null)
            throw new Exception("Course not found");

        boolean isDuplicated = studentsDAO.getById(student.getStudentID()) != null;
        if (isDuplicated)
            throw new Exception("An another student with same id exist");

        List<Student> courseStudents = course.getStudents();
        if (courseStudents.contains(student))
            throw new Exception("Student already enrolled for this course");

        studentsDAO.addStudent(student);
        courseStudents.add(student);
        student.add(linkTo(methodOn(StudentsController.class).getByID(student.getStudentID())).withSelfRel());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    @RequestMapping(value = "/courses/{courseID}/students/{studentID}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Course> enrollStudentForACourse(@PathVariable("courseID") String courseID,
                                                          @PathVariable("studentID") String studentID) throws Exception {

        Course course = courseDAO.getById(courseID);
        if (course == null)
            throw new Exception("Course not found");

        Student student = studentsDAO.getById(studentID);

        if (student == null)
            throw new Exception("Student not found");


        List<Student> courseStudents = course.getStudents();
        if (courseStudents.contains(student))
            throw new Exception("Student already enrolled for this course");

        courseStudents.add(student);
        return getByID(courseID);
    }


    @RequestMapping(value = "/courses/{courseID}/students", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Students> getStudentsForCourse(@PathVariable("courseID") String courseID) {
        Course course = courseDAO.getById(courseID);
        Students students = new Students(course.getStudents());
        for (Student student : students.getStudents()) {
            String studentID = student.getStudentID();
            student.removeLinks();
            student.add(linkTo(methodOn(StudentsController.class).getByID(studentID)).withSelfRel());
        }
        students.add(linkTo(methodOn(CourseController.class).getStudentsForCourse(courseID)).withSelfRel());
        students.add(linkTo(methodOn(CourseController.class).getByID(courseID)).withRel("course"));
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/courses", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Course> addCourse(@RequestBody Course course) throws Exception {
        if (courseDAO.getById(course.getCourseID()) != null)
            throw new Exception("Duplicate ID");
        courseDAO.addCourse(course);
        course.removeLinks();
        course.add(linkTo(methodOn(CourseController.class).getByID(course.getCourseID())).withSelfRel());
        course.add(linkTo(methodOn(SubjectController.class).getByID(course.getSubjectID())).withRel("subject"));
        return new ResponseEntity<>(course, HttpStatus.OK);
    }


}

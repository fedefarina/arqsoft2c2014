package com.fiuba.arqsoft.rest.controller;

import com.fiuba.arqsoft.rest.dao.CourseDAO;
import com.fiuba.arqsoft.rest.model.Course;
import com.fiuba.arqsoft.rest.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Fede on 12/4/14.
 */
@Controller
public class CourseController {

    private CourseDAO courseDAO;

    @Autowired
    public CourseController(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @RequestMapping(value = "/courses/{courseID}", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Course> getByID(@PathVariable("courseID") String courseID) {
        Course course = courseDAO.getById(courseID);
        course.removeLinks();
        course.add(linkTo(methodOn(CourseController.class).getByID(courseID)).withSelfRel());
        return new ResponseEntity<>(course, HttpStatus.OK);
    }


    @RequestMapping(value = "/courses/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Courses> getAllCourses() {
        Courses courses = new Courses(courseDAO.getAll());
        for (Course course : courses.getCourses()) {
            String studentID = course.getCourseID();
            course.add(linkTo(methodOn(CourseController.class).getByID(studentID)).withSelfRel());
        }
        courses.add(linkTo(methodOn(CourseController.class).getAllCourses()).withSelfRel());
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

}

package com.fiuba.arqsoft.rest.controller;

import com.fiuba.arqsoft.rest.dao.StudentsDao;
import com.fiuba.arqsoft.rest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class StudentsController {

    private StudentsDao studentsDao;

    @Autowired
    public StudentsController(StudentsDao studentsDao) {
        this.studentsDao = studentsDao;
    }

    @RequestMapping("/greeting")
    @ResponseBody
    public HttpEntity<Student> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        Student greeting = new Student("1", "Federico", "Farina");
        greeting.add(linkTo(methodOn(StudentsController.class).greeting(name)).withSelfRel());
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{studentID}", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Student> getByID(@PathVariable("studentID") String studentID) {
        Student student = studentsDao.getById(studentID);
        student.add(linkTo(methodOn(StudentsController.class).getByID(studentID)).withSelfRel());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }





 /*
       private StudentsDao studentsDao;
   @Autowired
    public StudentsController(StudentsDao studentsDao) {
        this.studentsDao = studentsDao;
    }

    @RequestMapping(value = "/student/{studentID}", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Student> getByID(@PathVariable String studentID) {
        Student student=studentsDao.getById(studentID);
        student.add(linkTo(student).withSelfRel());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }*/
}

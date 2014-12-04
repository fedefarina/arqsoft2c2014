package com.fiuba.arqsoft.rest.controller;

import com.fiuba.arqsoft.rest.dao.StudentsDao;
import com.fiuba.arqsoft.rest.model.Student;
import com.fiuba.arqsoft.rest.model.Students;
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

    @RequestMapping(value = "/students/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Students> getAllStudents() {
        Students students=new Students(studentsDao.getAll());
        for (Student student : students.getStudents()) {
            String studentID = student.getStudentID();
            student.add(linkTo(methodOn(StudentsController.class).getByID(studentID)).withSelfRel());
        }
        students.add(linkTo(methodOn(StudentsController.class).getAllStudents()).withSelfRel());
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @RequestMapping(value = "/students/{studentID}", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Student> getByID(@PathVariable("studentID") String studentID) {
        Student student = studentsDao.getById(studentID);
        student.removeLinks();
        student.add(linkTo(methodOn(StudentsController.class).getByID(studentID)).withSelfRel());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    @RequestMapping(value = "/students/{studentID}", method = RequestMethod.DELETE)
    @ResponseBody
    public HttpEntity<Student> deleteByID(@PathVariable("studentID") String studentID) {
        Student student = studentsDao.delete(studentID);
        student.removeLinks();
        student.add(linkTo(methodOn(StudentsController.class).getByID(studentID)).withSelfRel());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    @RequestMapping(value = "/students/", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public HttpEntity<Student> addStudent(@RequestBody Student student) {
        studentsDao.addStudent(student);
        student.removeLinks();
        student.add(linkTo(methodOn(StudentsController.class).getByID(student.getStudentID())).withSelfRel());
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
    public HttpEntity<Student> deleteByID(@PathVariable String studentID) {
        Student student=studentsDao.getById(studentID);
        student.add(linkTo(student).withSelfRel());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }*/
}

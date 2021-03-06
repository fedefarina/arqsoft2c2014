package com.fiuba.arqsoft.rest.controller;

import com.fiuba.arqsoft.rest.dao.StudentsDAO;
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

    private StudentsDAO studentsDAO;

    @Autowired
    public StudentsController(StudentsDAO studentsDAO) {
        this.studentsDAO = studentsDAO;
    }

    @RequestMapping(value = "/students/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Students> getAllStudents() {
        Students students = new Students(studentsDAO.getAll());
        for (Student student : students.getStudents()) {
            String studentID = student.getStudentID();
            student.removeLinks();
            student.add(linkTo(methodOn(StudentsController.class).getByID(studentID)).withSelfRel());
        }
        students.add(linkTo(methodOn(StudentsController.class).getAllStudents()).withSelfRel());
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{studentID}", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Student> getByID(@PathVariable("studentID") String studentID) {
        Student student = studentsDAO.getById(studentID);
        student.removeLinks();
        student.add(linkTo(methodOn(StudentsController.class).getByID(studentID)).withSelfRel());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{studentID}", method = RequestMethod.DELETE)
    @ResponseBody
    public HttpEntity<Student> deleteByID(@PathVariable("studentID") String studentID) throws Exception {
        Student student = studentsDAO.delete(studentID);
        if (student == null)
            throw new Exception("Student not found");
        student.removeLinks();
        student.add(linkTo(methodOn(StudentsController.class).getByID(studentID)).withSelfRel());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public HttpEntity<Student> addStudent(@RequestBody Student student) throws Exception {
        if (studentsDAO.getById(student.getStudentID()) != null)
            throw new Exception("Duplicate ID");
        studentsDAO.addStudent(student);
        student.removeLinks();
        student.add(linkTo(methodOn(StudentsController.class).getByID(student.getStudentID())).withSelfRel());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}

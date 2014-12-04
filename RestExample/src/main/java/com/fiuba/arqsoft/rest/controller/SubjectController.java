package com.fiuba.arqsoft.rest.controller;

import com.fiuba.arqsoft.rest.dao.SubjectDAO;
import com.fiuba.arqsoft.rest.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Fede on 12/4/14.
 */
@Controller
public class SubjectController {

    private SubjectDAO subjectDAO;

    @Autowired
    public SubjectController(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }


    @RequestMapping(value = "/subjects/{subjectID}", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Subject> getByID(@PathVariable("subjectID") String subjectID) {
        Subject subject = subjectDAO.getById(subjectID);
        subject.removeLinks();
        subject.add(linkTo(methodOn(SubjectController.class).getByID(subjectID)).withSelfRel());
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @RequestMapping(value = "/subjects/{subjectID}", method = RequestMethod.DELETE)
    @ResponseBody
    public HttpEntity<Subject> deleteByID(@PathVariable("subjectID") String subjectID) {
        Subject subject = subjectDAO.deleteByID(subjectID);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @RequestMapping(value = "/subjects", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public HttpEntity<Subject> add(@RequestBody Subject aSubject) {
        Subject subject = subjectDAO.addSubject(aSubject);
        subject.add(linkTo(methodOn(SubjectController.class).getByID(subject.getSubjectCode())).withSelfRel());
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }


}

package com.fiuba.arqsoft.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;

/**
 * Created by Fede on 12/4/14.
 */
public class Students extends ResourceSupport {

    private Collection<Student> students;

    public Students(@JsonProperty("students") Collection<Student> theStudents) {
        students = theStudents;
    }

    public Collection<Student> getStudents() {
        return students;
    }
}

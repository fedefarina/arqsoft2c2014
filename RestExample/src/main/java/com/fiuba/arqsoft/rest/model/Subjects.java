package com.fiuba.arqsoft.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;

/**
 * Created by Fede on 12/4/14.
 */
public class Subjects extends ResourceSupport {

    private Collection<Subject> subjects;

    public Subjects(@JsonProperty("subjects") Collection<Subject> theSubjects) {
        subjects = theSubjects;
    }

    public Collection<Subject> getSubjects() {
        return subjects;
    }
}

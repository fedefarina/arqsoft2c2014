package com.fiuba.arqsoft.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;

/**
 * Created by Fede on 12/4/14.
 */
public class Courses extends ResourceSupport {

    private Collection<Course> courses;

    public Courses(@JsonProperty("courses") Collection<Course> theCourses) {
        courses = theCourses;
    }

    public Collection<Course> getCourses() {
        return courses;
    }
}

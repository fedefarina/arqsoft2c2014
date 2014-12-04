package com.fiuba.arqsoft.rest.dao;

import com.fiuba.arqsoft.rest.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Created by Fede on 12/3/14.
 */

@org.springframework.stereotype.Repository
public class CourseDAO {

    private static final Logger LOG = LoggerFactory.getLogger(CourseDAO.class);

    public Collection<Course> getAll() {
        LOG.trace("Get all courses.");
        return Repository.getAllCourses().values();
    }

    public Course getById(String courseID) {
        LOG.trace("Get course by ID {}", courseID);
        return Repository.getAllCourses().get(courseID);
    }
}

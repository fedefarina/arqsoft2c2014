package com.fiuba.arqsoft.soap.dao;

import com.fiuba.arqsoft.soap.domain.Course;

import java.util.Collection;

/**
 * Created by Fede on 12/3/14.
 */

public class CourseDAO {


    public Collection<Course> getAll() {
        return Repository.getAllCourses().values();
    }

    public Course getById(String courseID) {
        return Repository.getAllCourses().get(courseID);
    }

    public Course addCourse(Course course) {
        Repository.getAllCourses().put(course.getCourseID(), course);
        return course;
    }
}

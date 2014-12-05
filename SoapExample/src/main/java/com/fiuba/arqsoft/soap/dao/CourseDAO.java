package com.fiuba.arqsoft.soap.dao;

import com.fiuba.arqsoft.soap.domain.Course;
import com.fiuba.arqsoft.soap.domain.Student;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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

    public Course delete(String courseID) {
        Map<String, Course> courses = Repository.getAllCourses();
        return courses.remove(courseID);
    }

    public void addStudentToCourse(Course course, Student student) {
        List<Student> courseStudents = course.getStudents();
        courseStudents.add(student);
    }
}

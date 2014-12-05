package com.fiuba.arqsoft.soap.domain;

import java.util.List;

/**
 * Created by Fede on 11/8/14.
 */


public class Student {

    private String studentID;

    private String name;
    private String lastName;

    List<Course> courses;

    List<Subject> subject;

    public Student() {
    }

    public Student(String anID, String aName, String aLastName) {
        studentID = anID;
        name = aName;
        lastName = aLastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String padron) {
        this.studentID = padron;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }
}

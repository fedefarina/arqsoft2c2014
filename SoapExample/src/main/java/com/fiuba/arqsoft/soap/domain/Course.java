package com.fiuba.arqsoft.soap.domain;


/**
 * Created by Fede on 11/8/14.
 */


public class Course {

    private String courseID;

    private String year;
    private String semester;


    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String id) {
        this.courseID = id;
    }
}

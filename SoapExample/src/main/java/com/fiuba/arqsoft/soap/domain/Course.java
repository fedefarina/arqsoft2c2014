package com.fiuba.arqsoft.soap.domain;


import java.util.List;

/**
 * Created by Fede on 11/8/14.
 */


public class Course {

    private String courseID;
    private String subjectID;
    private String year;
    private String semester;

    private List<Student> students;

    public Course() {
    }

    public Course(String aCourseID,
                  String aSubjectID,
                  String aYear,
                  String aSemester,
                  List<Student> theStudents) {
        courseID = aCourseID;
        subjectID = aSubjectID;
        year = aYear;
        semester = aSemester;
        students = theStudents;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String id) {
        courseID = id;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String aSubjectID) {
        subjectID = aSubjectID;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String aYear) {
        year = aYear;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String aSemester) {
        semester = aSemester;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

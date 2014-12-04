package com.fiuba.arqsoft.rest.model;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Fede on 11/8/14.
 */

@XmlRootElement
@XmlType(propOrder = {"courseID", "subjectID", "year", "semester"})
public class Course {

    private String mCourseID;
    private String mSubjectID;
    private String mYear;
    private String mSemester;

    public Course(String courseID, String subjectID, String year, String semester) {
        mCourseID = courseID;
        mSubjectID = subjectID;
        mYear = year;
        mSemester = semester;
    }

    public Course() {

    }

    public String getCourseID() {
        return mCourseID;
    }

    public void setCourseID(String id) {
        this.mCourseID = id;
    }

    public String getSubjectID() {
        return mSubjectID;
    }

    public void setSubjectID(String mSubjectID) {
        this.mSubjectID = mSubjectID;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String mYear) {
        this.mYear = mYear;
    }

    public String getSemester() {
        return mSemester;
    }

    public void setSemester(String mSemester) {
        this.mSemester = mSemester;
    }
}

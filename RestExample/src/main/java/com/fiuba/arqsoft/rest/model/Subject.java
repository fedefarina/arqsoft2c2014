package com.fiuba.arqsoft.rest.model;

/**
 * Created by Fede on 11/8/14.
 */

public class Subject {

    private String mSubjectCode;
    private String mName;

    public Subject(String subjectCode, String name) {
        mSubjectCode = subjectCode;
        mName = name;
    }

    public String getSubjectCode() {
        return mSubjectCode;
    }

    public void setSubjectCode(String code) {
        this.mSubjectCode = code;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }
}

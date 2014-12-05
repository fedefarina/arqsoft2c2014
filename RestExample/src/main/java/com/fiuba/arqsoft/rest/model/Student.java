package com.fiuba.arqsoft.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Fede on 11/8/14.
 */

public class Student extends ResourceSupport {

    private String studentID;
    private String name;
    private String lastName;

    public Student(@JsonProperty("studentID") String anID,
                   @JsonProperty("name") String aName,
                   @JsonProperty("lastName") String aLastName) {
        studentID = anID;
        name = aName;
        lastName = aLastName;
    }

    public Student() {

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

    @Override
    public boolean equals(Object obj) {
        return studentID.equals(((Student) obj).getStudentID());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + studentID +
                ", Name='" + name + '\'' +
                ", LastName=" + lastName +
                '}';
    }
}

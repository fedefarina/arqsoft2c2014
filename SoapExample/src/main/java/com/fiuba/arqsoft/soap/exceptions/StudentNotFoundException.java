package com.fiuba.arqsoft.soap.exceptions;

/**
 * Created by Fede on 11/8/14.
 */
public class StudentNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "No students found with the given criteria.";
    }
}

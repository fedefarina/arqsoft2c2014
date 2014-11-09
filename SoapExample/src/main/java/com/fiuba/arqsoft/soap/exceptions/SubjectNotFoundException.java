package com.fiuba.arqsoft.soap.exceptions;

/**
 * Created by Fede on 11/8/14.
 */
public class SubjectNotFoundException extends Exception{

    @Override
    public String getMessage() {
        return "No subjects found with the given criteria.";
    }
}

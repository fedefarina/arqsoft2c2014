package com.fiuba.arqsoft.soap.exceptions;

/**
 * Created by Fede on 11/9/14.
 */
public class StudentAlreadyExistException extends Exception {
    @Override
    public String getMessage() {
        return "There is already a student with this id.";
    }
}

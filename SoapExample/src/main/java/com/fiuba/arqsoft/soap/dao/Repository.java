package com.fiuba.arqsoft.soap.dao;

import com.fiuba.arqsoft.soap.domain.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fede on 11/9/14.
 */
public class Repository {

    public static Map<String, Student> getAllStudents() {
        Map<String, Student> students = new HashMap<String, Student>();
        students.put("90177", new Student("90177", "Federico", "Farina"));
        students.put("89009", new Student("89009", "Nicolas", "Icardi"));
        students.put("85678", new Student("85678", "Juan", "Perez"));
        students.put("87564", new Student("87564", "Martin", "Tartaglini"));
        students.put("87565", new Student("87565", "Ezequiel", "Garcia"));
        return students;
    }


}

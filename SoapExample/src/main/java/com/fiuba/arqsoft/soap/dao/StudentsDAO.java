package com.fiuba.arqsoft.soap.dao;

import com.fiuba.arqsoft.soap.domain.Student;

import java.util.Collection;
import java.util.Map;

public class StudentsDAO {

    public Student getById(String studentID) {
        return Repository.getAllStudents().get(studentID);
    }

    public Collection<Student> getAll() {
        return Repository.getAllStudents().values();
    }

    public Student addStudent(Student student) {
        Repository.getAllStudents().put(student.getStudentID(), student);
        return student;
    }

    public Student delete(String studentID) {
        Map<String, Student> students = Repository.getAllStudents();
        return students.remove(studentID);
    }
}

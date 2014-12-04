package com.fiuba.arqsoft.rest.dao;

import com.fiuba.arqsoft.rest.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;

@org.springframework.stereotype.Repository
public class StudentsDao {

    private static final Logger LOG = LoggerFactory.getLogger(StudentsDao.class);

    public Student getById(String studentID) {
        LOG.trace("Get student with ID {}", studentID);
        return Repository.getAllStudents().get(studentID);
    }

    public Collection<Student> getAll() {
        LOG.trace("Get all students.");
        return Repository.getAllStudents().values();
    }

    public Student addStudent(Student student) {
        LOG.trace("Add student: " + student);
        Repository.getAllStudents().put(student.getStudentID(), student);
        return student;
    }

    public Student delete(String studentID) {
        LOG.trace("Delete student with courseID: " + studentID);
        Map<String, Student> students = Repository.getAllStudents();
        return students.remove(studentID);
    }
}

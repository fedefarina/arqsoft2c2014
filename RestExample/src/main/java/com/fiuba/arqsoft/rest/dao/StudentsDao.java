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

    /*public Student getById(String courseID, String studentID) {
        LOG.trace("Get student with courseID {} belonging to course {}", studentID, courseID);

        Course course = Repository.getAllCourses().get(courseID);
        List<Student> students = null;
        Student studentWithID = null;

        if (course != null)
            students = course.getStudentsList();

        if (students != null) {
            for (Student student : students) {
                if (student.getStudentID().equals(studentID)) {
                    studentWithID = student;
                    break;
                }
            }
        }

        return studentWithID;
    }*/

/*    public List<Student> getByCourseID(String courseID) {
        LOG.trace("Get student by course courseID: " + courseID);
        List<Student> studentsByCourse = null;
        Course course = Repository.getAllCourses().get(courseID);
        if (course != null)
            studentsByCourse = course.getStudentsList();

        return studentsByCourse;
    }*/


    public Student addStudent(Student student) {
        LOG.trace("Add student: " + student);
        Map<String, Student> students = Repository.getAllStudents();
        return student;
    }


    public Student delete(String studentID) {
        LOG.trace("Delete student with courseID: " + studentID);
        Map<String, Student> students = Repository.getAllStudents();
        return students.remove(studentID);
    }
}

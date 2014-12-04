package com.fiuba.arqsoft.rest.dao;

import com.fiuba.arqsoft.rest.model.Course;
import com.fiuba.arqsoft.rest.model.Student;
import com.fiuba.arqsoft.rest.model.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Fede on 11/9/14.
 */
public class Repository {

    //Students
    private static Student federico = new Student("90177", "Federico", "Farina");
    private static Student nicolas = new Student("89009", "Nicolas", "Icardi");
    private static Student guillermo = new Student("85678", "Guillermo", "Rugilo");
    private static Student ezequiel = new Student("87565", "Ezequiel", "Garcia");

    //Subjects
    static Subject subject1 = new Subject("7531", "Teoría de Lenguaje");
    static Subject subject2 = new Subject("7532", "Arquitectura de Software");
    static Subject subject3 = new Subject("7533", "Otra materia");


    static Map<String, Student> students = new HashMap<>();
    static Map<String, Course> courses = new HashMap<>();
    static Map<String, Subject> subjects = new HashMap<>();

    public static void initRepository() {
        students.put(federico.getStudentID(), federico);
        students.put(nicolas.getStudentID(), nicolas);
        students.put(guillermo.getStudentID(), guillermo);
        students.put(ezequiel.getStudentID(), ezequiel);


        List<Student> students = new ArrayList<>();
        students.add(federico);
        students.add(nicolas);

        List<Student> students2 = new ArrayList<>();
        students2.add(guillermo);
        students2.add(ezequiel);

        //Courses
        Course firstCourse = new Course("1", "7531", "2014", "2", students);
        Course secondCourse = new Course("2", "7532", "2014", "2", students2);
        Course thirdCourse = new Course("3", "7533", "2014", "1", students2);


        courses.put(firstCourse.getCourseID(), firstCourse);
        courses.put(secondCourse.getCourseID(), secondCourse);
        courses.put(thirdCourse.getCourseID(), thirdCourse);
        subjects.put(subject1.getSubjectCode(), subject1);
        subjects.put(subject2.getSubjectCode(), subject2);
        subjects.put(subject3.getSubjectCode(), subject3);
    }


    public static Map<String, Student> getAllStudents() {
        return students;
    }


    public static Map<String, Course> getAllCourses() {
        return courses;
    }

    public static Map<String, Subject> getAllSubjects() {
        return subjects;
    }
}

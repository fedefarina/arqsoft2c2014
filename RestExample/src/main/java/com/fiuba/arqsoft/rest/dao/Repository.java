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

    //Courses
    private static Course firstCourse = new Course("1", "75.31", "2014", "2");
    private static Course secondCourse = new Course("2", "75.32", "2014", "2");
    private static Course thirdCourse = new Course("3", "75.33", "2014", "1");

    //Subjects
    static Subject subject1 = new Subject("75.31", "Teoría de Lenguaje");
    static Subject subject2 = new Subject("75.32", "Arquitectura de Software");
    static Subject subject3 = new Subject("75.33", "Otra materia");


    static Map<String, Student> students = new HashMap<>();
    static Map<String, Course> courses = new HashMap<>();
    static Map<String, Subject> subjects = new HashMap<>();

    public static void initRepository() {
        students.put(federico.getStudentID(), federico);
        students.put(nicolas.getStudentID(), nicolas);
        students.put(guillermo.getStudentID(), guillermo);
        students.put(ezequiel.getStudentID(), ezequiel);

        List<Course> list1 = new ArrayList<>();
        list1.add(firstCourse);
        list1.add(secondCourse);

        List<Course> list2 = new ArrayList<>();
        list2.add(thirdCourse);

                /*federico.setCourseList(list1);
        nicolas.setCourseList(list1);
        guillermo.setCourseList(list2);
        ezequiel.setCourseList(list2);
*/

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

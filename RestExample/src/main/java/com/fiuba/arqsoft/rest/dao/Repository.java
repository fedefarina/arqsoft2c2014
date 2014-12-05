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
    private static Student emiliano = new Student("81635", "Emiliano", "Chompas");
    private static Student lucia = new Student("90644", "Lucia", "Amaya");
    private static Student analia = new Student("91255", "Analia", "Toranzo");
    private static Student rosaura = new Student("92014", "Rosaura", "Castillo");
    private static Student celeste = new Student("80148", "Celeste", "Munoz");

    //Subjects
    static Subject subject1 = new Subject("7531", "Teoría de Lenguaje");
    static Subject subject2 = new Subject("7532", "Arquitectura de Software");
    static Subject subject3 = new Subject("6109", "Algebra");
    static Subject subject4 = new Subject("7112", "Estructura de las organizaciones");
    static Subject subject5 = new Subject("7509", "Tecnicas de Diseno");
    static Subject subject6 = new Subject("6202", "Materiales Industriales");
    static Subject subject7 = new Subject("6301", "Analisis Matematico");
    static Subject subject8 = new Subject("7505", "Taller de Programacion II");
    static Subject subject9 = new Subject("6405", "Estatica y Resistencia de Materiales");


    static Map<String, Student> students = new HashMap<>();
    static Map<String, Course> courses = new HashMap<>();
    static Map<String, Subject> subjects = new HashMap<>();

    public static void initRepository() {
        students.put(federico.getStudentID(), federico);
        students.put(nicolas.getStudentID(), nicolas);
        students.put(guillermo.getStudentID(), guillermo);
        students.put(ezequiel.getStudentID(), ezequiel);
        students.put(celeste.getStudentID(), celeste);
        students.put(rosaura.getStudentID(), rosaura);
        students.put(analia.getStudentID(), analia);
        students.put(lucia.getStudentID(), lucia);
        


        List<Student> students = new ArrayList<>();
        students.add(federico);
        students.add(nicolas);
        students.add(celeste);
        students.add(rosaura);

        List<Student> students2 = new ArrayList<>();
        students2.add(guillermo);
        students2.add(ezequiel);
        students2.add(analia);
        students2.add(lucia);
        
        List<Student> students3 = new ArrayList<>();
        students3.add(guillermo);
        students3.add(nicolas);
        students3.add(analia);
        students3.add(rosaura);
        
        List<Student> students4 = new ArrayList<>();
        students4.add(ezequiel);
        students4.add(nicolas);
        students4.add(lucia);
        students4.add(analia);
        
        

        //Courses
        Course firstCourse = new Course("1", "7531", "2014", "2", students);
        Course secondCourse = new Course("2", "7532", "2014", "2", students2);
        Course thirdCourse = new Course("3", "7533", "2014", "1", students2);
        Course fourthCourse = new Course("4", "6405", "2014", "2", students3);
        Course fivethCourse = new Course("5", "6109", "2014", "1", students4);


        courses.put(firstCourse.getCourseID(), firstCourse);
        courses.put(secondCourse.getCourseID(), secondCourse);
        courses.put(thirdCourse.getCourseID(), thirdCourse);
        courses.put(fourthCourse.getCourseID(), fourthCourse);
        courses.put(fivethCourse.getCourseID(), fivethCourse);
        
        subjects.put(subject1.getSubjectCode(), subject1);
        subjects.put(subject2.getSubjectCode(), subject2);
        subjects.put(subject3.getSubjectCode(), subject3);
        subjects.put(subject4.getSubjectCode(), subject4);
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

package com.fiuba.arqsoft.soap.dao;


import com.fiuba.arqsoft.soap.domain.Subject;

import java.util.Collection;

/**
 * Created by Fede on 12/4/14.
 */
public class SubjectDAO {


    public Collection<Subject> getAll() {
        return Repository.getAllSubjects().values();
    }

    public Subject getById(String subjectID) {
        return Repository.getAllSubjects().get(subjectID);
    }

    public Subject deleteByID(String subjectID) {
        return Repository.getAllSubjects().remove(subjectID);
    }

    public Subject addSubject(Subject subject) {
        return Repository.getAllSubjects().put(subject.getSubjectCode(), subject);
    }
}

package com.fiuba.arqsoft.rest.dao;

import com.fiuba.arqsoft.rest.model.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Fede on 12/4/14.
 */
@org.springframework.stereotype.Repository
public class SubjectDAO {

    private static final Logger LOG = LoggerFactory.getLogger(SubjectDAO.class);

    public Subject getById(String subjectID) {
        LOG.trace("Get subject with ID {}", subjectID);
        return Repository.getAllSubjects().get(subjectID);
    }

    public Subject deleteByID(String subjectID) {
        LOG.trace("Delete subject with ID {}", subjectID);
        return Repository.getAllSubjects().remove(subjectID);
    }

    public Subject addSubject(Subject subject) {
        return Repository.getAllSubjects().put(subject.getSubjectCode(), subject);
    }
}

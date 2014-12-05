package com.fiuba.arqsoft.soap.services.ws;

import com.fiuba.arqsoft.soap.dao.SubjectDAO;
import com.fiuba.arqsoft.soap.domain.Subject;
import com.fiuba.arqsoft.soap.services.SubjectsManagement;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import java.util.Collection;

/**
 * Created by Fede on 12/5/14.
 */

@WebService(endpointInterface = "com.fiuba.arqsoft.soap.services.SubjectsManagement",
        serviceName = "subjects", targetNamespace = "http://com.aam.jaxws.server/")
@BindingType(value = "http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
public class SubjectsWS implements SubjectsManagement {

    SubjectDAO subjectDAO = new SubjectDAO();

    public Collection<Subject> getAllSubjects() {
        return subjectDAO.getAll();
    }

    public Subject addSubject(String subjectCode, String name) throws Exception {
        Subject subject = subjectDAO.getById(subjectCode);
        if (subject != null)
            throw new Exception("There is already a subject with this id.");
        subject = new Subject(subjectCode, name);
        subjectDAO.addSubject(subject);
        return subject;
    }
}


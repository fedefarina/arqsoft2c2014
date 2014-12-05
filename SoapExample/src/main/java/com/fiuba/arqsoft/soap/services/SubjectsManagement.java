package com.fiuba.arqsoft.soap.services;

import com.fiuba.arqsoft.soap.domain.Subject;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Fede on 12/5/14.
 */

@WebService(name = "subjects")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface SubjectsManagement {

    public java.util.Collection<Subject> getAllSubjects();

    public Subject addSubject(@WebParam(name = "subjectCode") String subjectCOde,
                              @WebParam(name = "name") String name) throws Exception;

}

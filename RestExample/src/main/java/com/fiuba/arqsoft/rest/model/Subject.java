package com.fiuba.arqsoft.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Fede on 11/8/14.
 */

public class Subject extends ResourceSupport {

    private String subjectCode;
    private String name;


    public Subject(@JsonProperty("subjectCode") String aSubjectCode,
                   @JsonProperty("name") String aName) {
        subjectCode = aSubjectCode;
        name = aName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String code) {
        this.subjectCode = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

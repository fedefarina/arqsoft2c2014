package com.fiuba.arqsoft.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class Greeting extends ResourceSupport {

    private final String name;
    private final String lastName;

    @JsonCreator
    public Greeting(@JsonProperty("name") String aName,
                    @JsonProperty("lastName") String aLastName) {
        name = aName;
        lastName = aLastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}

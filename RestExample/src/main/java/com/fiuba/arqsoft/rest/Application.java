package com.fiuba.arqsoft.rest;

import com.fiuba.arqsoft.rest.dao.Repository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        Repository.initRepository();
        SpringApplication.run(Application.class, args);
    }

}

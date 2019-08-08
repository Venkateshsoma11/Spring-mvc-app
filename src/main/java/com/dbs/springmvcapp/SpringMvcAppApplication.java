package com.dbs.springmvcapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringMvcAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcAppApplication.class, args);
    }

}

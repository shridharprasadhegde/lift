package com.liftUp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by spjayara on 01/10/19.
 */

@SpringBootApplication

@ComponentScan(basePackages = "com.liftUp")
public class Main  {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }







}

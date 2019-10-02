package com.liftUp.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate;


/**
 * Created by spjayara on 01/10/19.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {




    @Bean
    public RestTemplate getRestTemplateOld(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }





}


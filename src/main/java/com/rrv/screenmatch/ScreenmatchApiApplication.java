package com.rrv.screenmatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ScreenmatchApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApiApplication.class, args);
    }

}

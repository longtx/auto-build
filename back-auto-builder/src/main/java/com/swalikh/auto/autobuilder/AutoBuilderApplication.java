package com.swalikh.auto.autobuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AutoBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoBuilderApplication.class, args);
    }

}

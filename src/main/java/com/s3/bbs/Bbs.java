package com.s3.bbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Bbs {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = SpringApplication.run(Bbs.class, args)) {
        }
    }
}

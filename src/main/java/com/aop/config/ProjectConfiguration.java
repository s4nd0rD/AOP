package com.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.aop.controller",
        "com.aop.service",
        // Add more package names as needed for your project
})
public class ProjectConfiguration {
    // Additional configuration beans or methods can be added here if needed
}


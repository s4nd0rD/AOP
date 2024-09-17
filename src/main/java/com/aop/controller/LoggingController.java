package com.aop.controller;

import com.aop.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoggingController {

    private final LoggingService loggingService;

    @Autowired
    public LoggingController(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome to the API!";
    }

    @PostMapping("/process")
    public String processInput(@RequestBody String input) {
        return loggingService.processInputString(input);
    }
}


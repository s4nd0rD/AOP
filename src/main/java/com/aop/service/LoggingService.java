package com.aop.service;

import org.springframework.stereotype.Service;
@Service
public class LoggingService {

    public String processInputString(String input) {
        System.out.println("Processing input: " + input);
        String result = input.toUpperCase();
        System.out.println("Processed result: " + result);
        return result;
    }
}

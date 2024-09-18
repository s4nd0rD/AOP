package com.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
public class LoggingService {

    private final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public String processInputString(String input) {
        logger.info("Processing input: {}", input);
        String result = input.toUpperCase();
        logger.info("Processing result: {}", result);
        return result;
    }
}

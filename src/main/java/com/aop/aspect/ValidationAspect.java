package com.aop.aspect;

import com.aop.exception.InputTooLongException;
import com.aop.exception.InvalidInputException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Aspect
@Component
public class ValidationAspect {

    private final Logger logger = LoggerFactory.getLogger(ValidationAspect.class);
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[&!@#$%^*()\\-+=]");
    private static final int MAX_LENGTH = 20;

    @Before("execution(* com.aop.service.*.*(..))")
    public void validateInput(JoinPoint joinPoint) {
        logger.info("Validating input for method: " + joinPoint.getSignature().getName());

        var args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof String) {
            var input = (String) args[0];

            if (SPECIAL_CHAR_PATTERN.matcher(input).find()) {
                logger.error("Invalid input with special characters detected: " + input);
                throw new InvalidInputException("Input contains invalid special characters!");
            }

            if (input.length() > MAX_LENGTH) {
                logger.error("Input is too long: " + input);
                throw new InputTooLongException("Input exceeds the maximum length of " + MAX_LENGTH + " characters!");
            }
        }
    }
}

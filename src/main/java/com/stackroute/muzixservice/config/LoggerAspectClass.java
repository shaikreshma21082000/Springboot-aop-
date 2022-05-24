package com.stackroute.muzixservice.config;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
//implement logger using AOP for all the methods
@Component
@Aspect
public class LoggerAspectClass {

    private static final Logger logger = LoggerFactory.getLogger(LoggerAspectClass.class);

    @Pointcut("execution (* com.stackroute.muzixservice.controller.MuzixController.saveTrack(..))")
    public void controllerMethods() {

    }

    @Before("controllerMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("**********@Before**********");
        logger.debug("Method Name: {}", joinPoint.getSignature().getName());
        logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));
        logger.info("**************************");
    }

    @After("controllerMethods()")
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("**********@After**********");
        logger.debug("Method Name: {}", joinPoint.getSignature().getName());
        logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));
        logger.info("**************************");
    }

    @AfterReturning(value="controllerMethods()",returning = "result")
    public void afterAdvice(JoinPoint joinPoint, Object result) {
        logger.info("**********@AfterReturning**********");
        logger.debug("Method Name: {}", joinPoint.getSignature().getName());
        logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));
        logger.debug("Return Value: {}", result);
        logger.info("**************************");
    }

    @AfterThrowing(value="controllerMethods()",throwing = "error")
    public void afterAdvice(JoinPoint joinPoint, Throwable error) {
        logger.info("**********@AfterThrowing**********");
        logger.debug("Method Name: {}", joinPoint.getSignature().getName());
        logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));
        logger.debug("Exception: {}", error);
        logger.info("**************************");
    }



}

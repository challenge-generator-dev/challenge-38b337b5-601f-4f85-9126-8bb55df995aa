package com.pragma.backend.infrastructure.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.pragma.backend.infrastructure.controller..*(..))")
    public void controllerMethods() {
    }

    @Pointcut("execution(* com.pragma.backend.application.service..*(..))")
    public void serviceMethods() {
    }

    @Around("controllerMethods()")
    public Object logControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes != null ? attributes.getRequest() : null;
        
        String requestInfo = "";
        if (request != null) {
            requestInfo = String.format("[%s] %s - ", request.getMethod(), request.getRequestURI());
        }
        
        logger.info("{}Iniciando ejecución: {}.{}()", requestInfo, className, methodName);
        
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            String argsSummary = Arrays.stream(args)
                    .map(arg -> {
                        if (arg == null) return "null";
                        if (arg instanceof HttpServletRequest) return "HttpServletRequest";
                        return arg.toString();
                    })
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("");
            logger.debug("{}Parámetros de {}.{}: [{}]", requestInfo, className, methodName, argsSummary);
        }
        
        long startTime = System.currentTimeMillis();
        Object result = null;
        Throwable error = null;
        
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Throwable ex) {
            error = ex;
            throw ex;
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            
            if (error != null) {
                logger.error("{}Error en {}.{}(): {} - Duración: {}ms", 
                        requestInfo, className, methodName, error.getMessage(), duration);
            } else {
                String resultSummary = result != null ? result.toString() : "void";
                if (resultSummary.length() > 200) {
                    resultSummary = resultSummary.substring(0, 200) + "...";
                }
                logger.info("{}Completado: {}.{}() - Duración: {}ms - Resultado: {}", 
                        requestInfo, className, methodName, duration, resultSummary);
            }
        }
    }

    @Around("serviceMethods()")
    public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        
        logger.debug("Iniciando servicio: {}.{}()", className, methodName);
        
        long startTime = System.currentTimeMillis();
        Object result = null;
        Throwable error = null;
        
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Throwable ex) {
            error = ex;
            throw ex;
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            
            if (error != null) {
                logger.error("Error en servicio {}.{}(): {} - Duración: {}ms", 
                        className, methodName, error.getMessage(), duration);
            } else {
                logger.debug("Completado servicio: {}.{}() - Duración: {}ms", 
                        className, methodName, duration);
            }
        }
    }
}
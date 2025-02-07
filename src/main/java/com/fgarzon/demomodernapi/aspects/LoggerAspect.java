package com.fgarzon.demomodernapi.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    // Antes de ejecutar un método de UserService
    @Before(value = "execution(* com.fgarzon.demomodernapi.service.IUserService.*(..))")
    public void beforeUserService(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("-> [LOG] before method execution at UserService with args: "+ Arrays.toString(args));
    }

    @After(value = "execution(* com.fgarzon.demomodernapi.service.IUserService.*(..))")
    public void afterUserService() {
        System.out.println("-> [LOG] after method execution at UserService");
    }

}



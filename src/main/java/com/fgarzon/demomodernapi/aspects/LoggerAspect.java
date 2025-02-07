package com.fgarzon.demomodernapi.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    // Antes de ejecutar un método de UserService
    @Before(value = "execution(* com.fgarzon.demomodernapi.service.IUserService.*(..))")
    public void beforeUserService() {
        System.out.println("-> [LOG] before method execution at SaludoService");
    }

    @After(value = "execution(* com.fgarzon.demomodernapi.service.IUserService.*(..))")
    public void afterUserService() {
        System.out.println("-> [LOG] after method execution at SaludoService");
    }

}

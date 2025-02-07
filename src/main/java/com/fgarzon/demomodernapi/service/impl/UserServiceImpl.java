package com.fgarzon.demomodernapi.service.impl;

import com.fgarzon.demomodernapi.dto.CredentialsDto;
import com.fgarzon.demomodernapi.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    public String sayHello(String name) {
        System.out.printf("Hello %s!%n", name);
        return String.format("Hello %s!", name);
    }

    @Override
    public String login(CredentialsDto credentialsDto) {
        System.out.println("Login called");
        return "Login Successful";
    }
}

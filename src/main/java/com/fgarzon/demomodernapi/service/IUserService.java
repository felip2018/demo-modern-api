package com.fgarzon.demomodernapi.service;

import com.fgarzon.demomodernapi.dto.CredentialsDto;

public interface IUserService {
    String sayHello(String name);
    String login(CredentialsDto credentials);
}

package com.fgarzon.demomodernapi.controller;

import com.fgarzon.demomodernapi.dto.CredentialsDto;
import com.fgarzon.demomodernapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    IUserService userService;

    @GetMapping("/say-hello/{name}")
    public ResponseEntity<String> hello(@PathVariable String name) {
        return ResponseEntity.ok(userService.sayHello(name));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CredentialsDto credentialsDto) {
        return ResponseEntity.ok(userService.login(credentialsDto));
    }
}

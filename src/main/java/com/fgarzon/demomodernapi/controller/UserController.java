package com.fgarzon.demomodernapi.controller;

import com.fgarzon.demomodernapi.dto.CredentialsDto;
import com.fgarzon.demomodernapi.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/say-hello/{name}")
    public ResponseEntity<String> hello(@PathVariable String name) {
        return ResponseEntity.ok(userService.sayHello(name));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody CredentialsDto credentialsDto) {
        return ResponseEntity.ok(userService.login(credentialsDto));
    }
}

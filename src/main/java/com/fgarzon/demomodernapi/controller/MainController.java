package com.fgarzon.demomodernapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/say-hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }
}

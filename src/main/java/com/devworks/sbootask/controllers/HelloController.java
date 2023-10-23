package com.devworks.sbootask.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public static ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello spring boot world");
    }

}

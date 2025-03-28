package com.amreshmaurya.url_shortner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity<HashMap<String, String>> healthCheck() {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "It works");

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}

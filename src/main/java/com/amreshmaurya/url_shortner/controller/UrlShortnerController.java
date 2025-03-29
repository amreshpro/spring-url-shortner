package com.amreshmaurya.url_shortner.controller;

import com.amreshmaurya.url_shortner.repository.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class UrlShortnerController {
    private UrlShortnerService urlShortnerService;

    @Autowired
    UrlShortnerController( UrlShortnerService urlShortnerService){
        this.urlShortnerService =urlShortnerService;
    }
    @GetMapping
    ResponseEntity<String> testMyService(){
        return urlShortnerService.testService();
    }

    @PostMapping
    ResponseEntity<HashMap<String,String >> setUrlToShorten(@RequestBody(required = true) HashMap<String,String> body ){
        return  ResponseEntity.status(201).body(body);
    }

}

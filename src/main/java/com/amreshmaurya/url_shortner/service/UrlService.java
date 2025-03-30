package com.amreshmaurya.url_shortner.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Service
public class UrlService {


    public ResponseEntity<HashMap<String,String>> urlForShorten(@RequestBody(required = true) HashMap<String,String> url){
      return ResponseEntity.status(201).body(url);
    }
}

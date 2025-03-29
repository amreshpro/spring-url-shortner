package com.amreshmaurya.url_shortner.repository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Service
public class UrlShortnerService {

  public ResponseEntity<String> testService(){
        return  ResponseEntity.status(HttpStatus.OK).body("Service is working");
    }


    public ResponseEntity<HashMap<String,String>> urlForShorten(@RequestBody(required = true) HashMap<String,String> url){
      return ResponseEntity.status(201).body(url);
    }
}

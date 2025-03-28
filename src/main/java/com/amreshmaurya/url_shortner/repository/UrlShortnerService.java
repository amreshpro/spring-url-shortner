package com.amreshmaurya.url_shortner.repository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UrlShortnerService {

  public ResponseEntity<String> testService(){
        return  ResponseEntity.status(HttpStatus.OK).body("Service is working");
    }
}

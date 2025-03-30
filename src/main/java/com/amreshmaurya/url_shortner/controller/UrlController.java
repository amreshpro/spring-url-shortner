package com.amreshmaurya.url_shortner.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amreshmaurya.url_shortner.entity.UrlEntity;
import com.amreshmaurya.url_shortner.service.UrlService;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/url")
public class UrlController {
    private UrlService urlService;

  
    UrlController( UrlService urlShortnerService){
        this.urlService = urlService;
    }
  

    @PostMapping("/shorten")
    ResponseEntity<UrlEntity> shortenUrl(@RequestBody(required = true) UrlEntity body ){
      log.info("body: "+body);
        return  ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

}

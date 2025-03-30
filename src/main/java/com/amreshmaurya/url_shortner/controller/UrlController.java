package com.amreshmaurya.url_shortner.controller;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.amreshmaurya.url_shortner.entity.UrlEntity;
import com.amreshmaurya.url_shortner.service.UrlService;


@Slf4j
@RestController
@RequestMapping("/url")
public class UrlController {
    private UrlService urlService;

  
    UrlController( UrlService urlService){
        this.urlService = urlService;
    }
  

    @PostMapping("/shorten")
    public ResponseEntity<?> shortenUrl(@RequestBody UrlEntity url) {
      String shortenedUrl = urlService.createShortUrl(url.getOriginalUrl(),LocalDateTime.now().plusDays(30));
        
        if (shortenedUrl != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(shortenedUrl);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error: Invalid URL");
        }
    }

}

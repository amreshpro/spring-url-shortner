package com.amreshmaurya.url_shortener.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amreshmaurya.url_shortener.entity.UrlEntity;
import com.amreshmaurya.url_shortener.repository.UrlRepository;


@Service
public class UrlService {

 private UrlRepository urlRepository;

 UrlService(UrlRepository urlRepository){
  this.urlRepository = urlRepository;

 }


 
    @Transactional
    public String createShortUrl(String originalUrl, LocalDateTime expiryTime) {
      if(originalUrl != null){

              UrlEntity shortenedUrl = UrlEntity.builder()
                .originalUrl(originalUrl)
                .id(UUID.randomUUID()).shortCode(UUID.randomUUID().toString().substring(1,7))
                .createdAt(LocalDateTime.now())
                .expiresAt(expiryTime != null ? expiryTime : LocalDateTime.now().plusDays(30))
                .build();

                     shortenedUrl =  urlRepository.save(shortenedUrl);
     
                     return shortenedUrl.getShortCode();
                    }
                    return null;
    }

}

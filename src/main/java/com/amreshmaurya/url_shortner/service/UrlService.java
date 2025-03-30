package com.amreshmaurya.url_shortner.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hashids.Hashids;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import com.amreshmaurya.url_shortner.entity.UrlEntity;
import com.amreshmaurya.url_shortner.repository.UrlRepository;


@Service
public class UrlService {

 private UrlRepository urlRepository;
 private Hashids hashids;

 UrlService(UrlRepository urlRepository,Hashids hashids){
  this.urlRepository = urlRepository;
  this.hashids = new Hashids("my-secret-salt",8);

 }

  public UrlEntity urlForShorten(@RequestBody(required = true) UrlEntity url) {
    if (url != null) {
      urlRepository.save(url);
      return url;
    } else {
      return null;
    }
  }

 
    @Transactional
    public String createShortUrl(String originalUrl, LocalDateTime expiryTime) {
        UrlEntity shortenedUrl = UrlEntity.builder()
                .originalUrl(originalUrl)
                .id(UUID.randomUUID())
                .createdAt(LocalDateTime.now())
                .expiresAt(expiryTime != null ? expiryTime : LocalDateTime.now().plusDays(30))
                .build();

                shortenedUrl = urlRepository.save(shortenedUrl); // ✅ Save first to get ID

                String shortCode = hashids.encodeHex(shortenedUrl.getId().toString());
                
                shortenedUrl.setShortCode(shortCode);
                urlRepository.save(shortenedUrl);

        return shortCode;
    }

}

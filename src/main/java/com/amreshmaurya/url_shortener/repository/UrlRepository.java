package com.amreshmaurya.url_shortener.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amreshmaurya.url_shortener.entity.UrlEntity;
import com.amreshmaurya.url_shortener.entity.User;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, UUID> {
    Optional<UrlEntity> findByShortCode(String shortCode);
    List<UrlEntity> findByUser(User user);
}
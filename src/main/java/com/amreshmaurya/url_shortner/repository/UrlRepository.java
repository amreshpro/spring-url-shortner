package com.amreshmaurya.url_shortner.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.amreshmaurya.url_shortner.entity.UrlEntity;

public interface UrlRepository extends JpaRepository<UrlEntity,UUID> {

    
}

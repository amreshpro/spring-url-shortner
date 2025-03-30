package com.amreshmaurya.url_shortner.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "urls", indexes = {@Index(name = "idx_url", columnList = "url")})
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Auto-generate UUID
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private UUID id;

    // @Lob // Allows storing long URLs
    @Column(name = "url", nullable = false, unique = true)
    private String url;

    // Constructor for creating URL entity without ID (UUID is auto-generated)
    public UrlEntity(String url) {
        this.url = url;
    }
}

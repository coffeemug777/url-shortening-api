package com.dennywibowo.urlshorteningapi.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class UrlData {
    @Id
    private Long id;
    private String url ;
    private String shortUrl;
}

package com.dennywibowo.urlshorteningapi.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlData {
    private Long id;
    private String url ;
    private String shortUrl;
}

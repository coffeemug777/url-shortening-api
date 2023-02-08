package com.dennywibowo.urlshorteningapi.service;

import com.dennywibowo.urlshorteningapi.dto.UrlDataRequest;
import com.dennywibowo.urlshorteningapi.dto.UrlDataResponse;
import org.springframework.stereotype.Service;

@Service
public class UrlDataService {
    public UrlDataResponse createUrl(UrlDataRequest request) {
        String shortenedUrl = generateShortenedUrl(request.getUrl());
        UrlDataResponse newResponse= UrlDataResponse.builder()
                .url(request.getUrl())
                .shortUrl(shortenedUrl)
                .build();

        return newResponse;
    }

    private String generateShortenedUrl(String urlInput) {
        return "short";
    }
}

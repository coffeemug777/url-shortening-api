package com.dennywibowo.urlshorteningapi.controller;

import com.dennywibowo.urlshorteningapi.dto.UrlDataRequest;
import com.dennywibowo.urlshorteningapi.dto.UrlDataResponse;
import com.dennywibowo.urlshorteningapi.service.UrlDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UrlShorteningController {
    private final UrlDataService urlDataService;

    @Autowired
    public UrlShorteningController(UrlDataService urlDataService) {
        this.urlDataService = urlDataService;
    }

    @PostMapping("/create")
    public UrlDataResponse createUrl(@RequestBody UrlDataRequest request) {
        return urlDataService.createUrl(request);
    }
}

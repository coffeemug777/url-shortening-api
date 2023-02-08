package com.dennywibowo.urlshorteningapi.controller;

import com.dennywibowo.urlshorteningapi.dto.UrlDataRequest;
import com.dennywibowo.urlshorteningapi.dto.UrlDataResponse;
import com.dennywibowo.urlshorteningapi.service.UrlDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UrlShorteningController {
    private final UrlDataService urlDataService;

    @Autowired
    public UrlShorteningController(UrlDataService urlDataService) {
        this.urlDataService = urlDataService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UrlDataResponse createUrl(@RequestBody UrlDataRequest request) {
        return urlDataService.createUrl(request);
    }
}

package com.dennywibowo.urlshorteningapi.controller;

import com.dennywibowo.urlshorteningapi.dto.UrlDataRequest;
import com.dennywibowo.urlshorteningapi.dto.UrlDataResponse;
import com.dennywibowo.urlshorteningapi.service.UrlDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UrlDataResponse getUrl(@PathVariable Long id) {
        return urlDataService.getUrl(id);
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UrlDataResponse> getAll() {
        return urlDataService.getAll();
    }

}

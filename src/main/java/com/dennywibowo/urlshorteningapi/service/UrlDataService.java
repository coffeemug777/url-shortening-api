package com.dennywibowo.urlshorteningapi.service;

import com.dennywibowo.urlshorteningapi.dto.UrlDataRequest;
import com.dennywibowo.urlshorteningapi.dto.UrlDataResponse;
import com.dennywibowo.urlshorteningapi.model.UrlData;
import com.dennywibowo.urlshorteningapi.repository.UrlDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.*;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.xml.bind.DatatypeConverter;

@Service
public class UrlDataService {
    private final UrlDataRepository urlDataRepository;

    @Autowired
    public UrlDataService(UrlDataRepository urlDataRepository) {
        this.urlDataRepository = urlDataRepository;
    }

    public UrlDataResponse createUrl(UrlDataRequest request) {
        String shortenedUrl = generateShortenedUrl(request.getUrl());

        UrlData savedData = urlDataRepository.save(UrlData.builder()
                        .url(request.getUrl())
                        .shortUrl(shortenedUrl)
                        .build());

        // do check for duplicated URL;
        // while not duplicate, generateShortenedUrl

        UrlDataResponse newResponse= mapToUrlDataResponse(savedData);
        return newResponse;
    }

    public UrlDataResponse getUrl(Long id) {
        return mapToUrlDataResponse(urlDataRepository.getReferenceById(id));
    }

    public List<UrlDataResponse> getAll() {
        return urlDataRepository.findAll().stream().map(urlData1 -> mapToUrlDataResponse(urlData1)).toList();
    }

    private String generateShortenedUrl(String urlInput) {
        try {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSSSSS").format(new java.util.Date());
            String urlPlusTime = urlInput.concat(timeStamp);
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(urlPlusTime.getBytes());
            byte[] digest = md.digest();
            String myHash = DatatypeConverter
                    .printHexBinary(digest).toLowerCase();
            String myHash7 = myHash.substring(myHash.length() - 7);
            return myHash7;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error in no such algo");
            System.out.println(e);
        }
        return "";
    }

    private UrlDataResponse mapToUrlDataResponse(UrlData urlData) {
        return UrlDataResponse.builder()
                .id(urlData.getId())
                .url(urlData.getUrl())
                .shortUrl(urlData.getShortUrl())
                .build();
    }

}

package com.dennywibowo.urlshorteningapi.service;

import com.dennywibowo.urlshorteningapi.dto.UrlDataRequest;
import com.dennywibowo.urlshorteningapi.dto.UrlDataResponse;
import org.springframework.stereotype.Service;
import java.security.*;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.DatatypeConverter;

@Service
public class UrlDataService {
    private List<UrlDataResponse> urlData = new ArrayList<>();
    private Long counter = 1L;

    public UrlDataResponse createUrl(UrlDataRequest request) {
        String shortenedUrl = generateShortenedUrl(request.getUrl());

        // do check for duplicated URL;
        // while not duplicate, generateShortenedUrl
        UrlDataResponse newResponse= UrlDataResponse.builder()
                .id(counter)
                .url(request.getUrl())
                .shortUrl(shortenedUrl)
                .build();

        urlData.add(newResponse);
        counter = counter + 1L;

        return newResponse;
    }

    private String generateShortenedUrl(String urlInput) {
        try {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
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
}

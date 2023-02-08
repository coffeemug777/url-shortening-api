package com.dennywibowo.urlshorteningapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlDataResponse {
    private Long id;
    private String url ;
    private String shortUrl;
}

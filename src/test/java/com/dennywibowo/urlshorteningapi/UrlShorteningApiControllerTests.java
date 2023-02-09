package com.dennywibowo.urlshorteningapi;

import com.dennywibowo.urlshorteningapi.controller.UrlShorteningController;
import com.dennywibowo.urlshorteningapi.dto.UrlDataRequest;
import com.dennywibowo.urlshorteningapi.dto.UrlDataResponse;
import com.dennywibowo.urlshorteningapi.repository.UrlDataRepository;
import com.dennywibowo.urlshorteningapi.service.UrlDataService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class UrlShorteningApiApplicationTests {
	@InjectMocks
	private UrlShorteningController controller;

	@Mock
	private UrlDataService urlDataService;

	@Test
	void UrlShorteningController_test() {
		UrlDataRequest testRequest = new UrlDataRequest();
		testRequest.setUrl("http://test.org/some/page/1");
		UrlDataResponse newResponse= UrlDataResponse.builder()
				.id(1L)
				.url("http://test.org/some/page/1")
				.shortUrl("1234567")
				.build();

		when(urlDataService.createUrl(testRequest)).thenReturn(newResponse);

		UrlDataResponse result =  controller.createUrl(testRequest);

		verify(urlDataService, Mockito.times(1)).createUrl(testRequest);
		assertEquals(newResponse, result);
	}

}

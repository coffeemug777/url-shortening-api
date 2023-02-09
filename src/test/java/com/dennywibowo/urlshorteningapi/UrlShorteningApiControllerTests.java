package com.dennywibowo.urlshorteningapi;

import com.dennywibowo.urlshorteningapi.controller.UrlShorteningController;
import com.dennywibowo.urlshorteningapi.dto.UrlDataRequest;
import com.dennywibowo.urlshorteningapi.dto.UrlDataResponse;
import com.dennywibowo.urlshorteningapi.service.UrlDataService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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
	void UrlShorteningController_create_test() {
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

	@Test
	void UrlShorteningController_get_test() {
		UrlDataRequest testRequest = new UrlDataRequest();
		testRequest.setUrl("http://test.org/some/page/1");
		UrlDataResponse newResponse= UrlDataResponse.builder()
				.id(1L)
				.url("http://test.org/some/page/1")
				.shortUrl("1234567")
				.build();

		when(urlDataService.getUrl(1L)).thenReturn(newResponse);

		UrlDataResponse result =  controller.getUrl(1L);

		verify(urlDataService, Mockito.times(1)).getUrl(1L);
		assertEquals(newResponse, result);
	}

	@Test
	void UrlShorteningController_getAll_test() {
		List<UrlDataResponse> arrResponses = new ArrayList<>();
		arrResponses.add(
				UrlDataResponse.builder()
				.id(1L)
				.url("http://test.org/some/page/1")
				.shortUrl("1234567")
				.build());
		arrResponses.add(UrlDataResponse.builder()
				.id(3L)
				.url("http://test.org/some/page/3")
				.shortUrl("1234567")
				.build());
		arrResponses.add(UrlDataResponse.builder()
				.id(2L)
				.url("http://test.org/some/page/2")
				.shortUrl("1234567")
				.build());


		when(urlDataService.getAll()).thenReturn(arrResponses);

		List<UrlDataResponse> result =  controller.getAll();

		verify(urlDataService, Mockito.times(1)).getAll();
		assertEquals(arrResponses, result);
	}

}

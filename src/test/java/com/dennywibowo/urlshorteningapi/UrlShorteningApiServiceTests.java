package com.dennywibowo.urlshorteningapi;

import com.dennywibowo.urlshorteningapi.dto.UrlDataRequest;
import com.dennywibowo.urlshorteningapi.dto.UrlDataResponse;
import com.dennywibowo.urlshorteningapi.repository.UrlDataRepository;
import com.dennywibowo.urlshorteningapi.service.UrlDataService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class UrlShorteningApiServiceTests {

    @Autowired
    private UrlDataRepository urlDataRepository;


    @Test
    @Transactional
    void UrlDataService_createUrl_Test() {
        UrlDataService testService = new UrlDataService(urlDataRepository);
        UrlDataRequest testRequest = new UrlDataRequest();
        testRequest.setUrl("http://test.org/some/page/1");

        UrlDataResponse result = testService.createUrl(testRequest);

        assertAll("url",
                () -> assertEquals(1, result.getId()),
                () -> assertEquals("http://test.org/some/page/1", result.getUrl()),
                () -> assertEquals(7, result.getShortUrl().length())
        );

        UrlDataResponse result2 = testService.createUrl(testRequest);
        assertEquals(2, result2.getId());
    }

	@Test
    @Transactional
	void UrlDataService_getUrl_Test() {
		UrlDataService testService = new UrlDataService(urlDataRepository);

		UrlDataRequest testRequest1 = new UrlDataRequest();
		testRequest1.setUrl("http://test.org/some/page/1");
        testService.createUrl(testRequest1);

        UrlDataRequest testRequest2 = new UrlDataRequest();
        testRequest2.setUrl("http://test.org/some/page/2");
        testService.createUrl(testRequest2);

        UrlDataRequest testRequest3 = new UrlDataRequest();
        testRequest3.setUrl("http://test.org/some/page/3");
        testService.createUrl(testRequest3);

        UrlDataResponse result3 = testService.getUrl(3L);
        assertEquals("http://test.org/some/page/3", result3.getUrl());


        UrlDataResponse result2 = testService.getUrl(2L);
        assertEquals("http://test.org/some/page/2", result2.getUrl());

        UrlDataResponse result1 = testService.getUrl(1L);
        assertEquals("http://test.org/some/page/1", result1.getUrl());
    }

    @Test
    @Transactional
    void UrlDataService_getAll_Test() {
        UrlDataService testService = new UrlDataService(urlDataRepository);
        UrlDataRequest testRequest1 = new UrlDataRequest();
        testRequest1.setUrl("http://test.org/some/page/1");
        testService.createUrl(testRequest1);

        List<UrlDataResponse> results = testService.getAll();

        assertEquals(1, results.size());

        UrlDataRequest testRequest2 = new UrlDataRequest();
        testRequest2.setUrl("http://test.org/some/page/2");
        testService.createUrl(testRequest2);

        List<UrlDataResponse> results2 = testService.getAll();

        assertEquals(2, results2.size());
    }
}

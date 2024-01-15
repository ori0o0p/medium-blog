package com.example.mediumspringwebclientexternalapi;

import com.example.mediumspringwebclientexternalapi.api.WebClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MediumSpringWebClientExternalApiApplicationTests {

	@Autowired
	private WebClientService webClientService;

	@Test
	void get() {
		webClientService.get();
	}

}

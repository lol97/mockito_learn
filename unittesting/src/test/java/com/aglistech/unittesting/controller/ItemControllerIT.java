package com.aglistech.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() throws JSONException {
		String response = restTemplate.getForObject("/retrieve-from-database", String.class);
		
		JSONAssert.assertEquals("[{id:1001}, {id:1002}]", response, false);
	}
}

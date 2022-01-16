package com.aglistech.unittesting.spike;

//import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {
	String actualResponse = "{\"id\":1,\"name\":\"Baso\",\"price\":10000,\"quantity\":2}";
	
	@Test
	void jsonAssert_StrictTrue() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Baso\",\"price\":10000,\"quantity\":2}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	
	@Test
	void jsonAssert_StrictFalse() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Baso\",\"price\":10000}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	@Test
	void jsonAssert_WithoutEscape() throws JSONException {
		String expectedResponse = "{id:1,\"name\":\"Baso\",\"price\":10000}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

}

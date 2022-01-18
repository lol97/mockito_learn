package com.aglistech.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;import java.util.List;
import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {
	@Test
	public void learning() {
		String responseFromService = "[\r\n"
				+ "{\"id\":10001, \"name\":\"Baso\", \"quantity\":5},\r\n"
				+ "{\"id\":10002, \"name\":\"Mie\", \"quantity\":15},\r\n"
				+ "{\"id\":10003, \"name\":\"Ayam\", \"quantity\":3},\r\n"
				+ "]";
		DocumentContext context = JsonPath.parse(responseFromService);
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		List<Integer> ids = context.read("$..id");
		assertThat(ids).containsExactly(10001,10002,10003);
		
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:2]").toString());
		System.out.println(context.read("$.[?(@.name=='Mie')]").toString());
		System.out.println(context.read("$.[?(@.quantity==5)]").toString());
	}
}

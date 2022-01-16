package com.aglistech.unittesting.controller;


import static org.mockito.Mockito.when;
//import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.aglistech.unittesting.model.Item;
import com.aglistech.unittesting.service.ItemBusinessService;

@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void itemdummy_basic() throws Exception{
		//call /hello-world
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-dummy").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Baso\",\"price\":10000,\"quantity\":2}")) 
				.andReturn();
	}
	
	@Test
	public void itemFromBusinessService() throws Exception{
		when(businessService.retrieveHardCodeItem()).thenReturn(new Item(1, "Baso", 10000, 2));
		
		//call /hello-world
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-dummy").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:1,name:Baso,price:10000,quantity:2}")) 
				.andReturn();
	}
	
	@Test
	public void retrieveAllItem_basic() throws Exception{
		when(businessService.retrieveAllItems())
			.thenReturn( Arrays.asList(new Item(1, "Baso", 10000, 2), new Item(2, "Baso2", 20000, 2)));
		
		//call /hello-world
		RequestBuilder request = MockMvcRequestBuilders
				.get("/retrieve-from-database").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:1,name:Baso,price:10000,quantity:2}, {id:2,name:Baso2,price:20000,quantity:2}]")) 
				.andReturn();
	}
}

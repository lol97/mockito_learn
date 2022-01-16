package com.aglistech.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aglistech.unittesting.model.Item;
import com.aglistech.unittesting.service.ItemBusinessService;

@RestController
public class ItemController {
	@Autowired
	private ItemBusinessService businessService;
	
	@GetMapping("/item-dummy")
	public Item itemDummy() {
		return new Item(1, "Baso", 10000, 2);
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		return businessService.retrieveHardCodeItem();
	}
	
	@GetMapping("/retrieve-from-database")
	public List<Item> retrieveFromDatabase(){
		return businessService.retrieveAllItems();
	}
}

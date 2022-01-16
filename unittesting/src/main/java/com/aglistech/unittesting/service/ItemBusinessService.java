package com.aglistech.unittesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aglistech.unittesting.data.ItemRepository;
import com.aglistech.unittesting.model.Item;

@Component
public class ItemBusinessService {
	@Autowired
	private ItemRepository itemRepository;
	
	public Item retrieveHardCodeItem() {
		return new Item(1, "Baso", 10000, 2);
	}
	
	public List<Item> retrieveAllItems(){
		List<Item> items = itemRepository.findAll();
		for(Item item : items) {
			item.setValue(item.getPrice()*item.getQuantity());
		}
		return items;
	}
}

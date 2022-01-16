package com.aglistech.unittesting.business;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aglistech.unittesting.data.ItemRepository;
import com.aglistech.unittesting.model.Item;
import com.aglistech.unittesting.service.ItemBusinessService;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {
	
	@InjectMocks
	private ItemBusinessService businessService;
	
	@Mock
	private ItemRepository itemRepository;
	
	@Test
	public void retrieveAllItems_basic() {
		when(itemRepository.findAll()).thenReturn(
				Arrays.asList(
						new Item(1, "Baso", 10000, 2), 
						new Item(2, "Baso2", 20000, 2)
						)
				);
		List<Item> items = businessService.retrieveAllItems();
		Assertions.assertEquals(20000, items.get(0).getValue());
		Assertions.assertEquals(40000, items.get(1).getValue());
	}
}

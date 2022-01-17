package com.aglistech.unittesting.data;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.aglistech.unittesting.model.Item;

@DataJpaTest
public class ItemRepositoryTest {
	@Autowired
	private ItemRepository itemRepository;
	
	/**
	 * 
	 */
	@Test
	public void testFindAll() {
		List<Item> items = itemRepository.findAll();
		Assertions.assertEquals(2, items.size());
	}
}

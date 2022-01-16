package com.aglistech.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aglistech.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}

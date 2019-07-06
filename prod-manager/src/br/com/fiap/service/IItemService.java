package br.com.fiap.service;

import java.util.List;

import br.com.fiap.entity.Item;

public interface IItemService {

	List<Item> getAll();		
	Item getById(int id);
	Item add(Item item);
	Item update(Item item);
	void delete(int id);
}

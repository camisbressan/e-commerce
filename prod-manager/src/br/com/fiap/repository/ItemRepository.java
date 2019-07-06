package br.com.fiap.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}

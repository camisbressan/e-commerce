package br.com.fiap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import br.com.fiap.entity.Item;
import br.com.fiap.repository.ItemRepository;

@Service
public class ItemService implements IItemService {

	@Autowired
	private ItemRepository repo;
	
	@Override
	@Cacheable(value= "allItemsCache", unless= "#result.size() == 0")
	public List<Item> getAll() {
		List<Item> list = new ArrayList<>();
		repo.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	@Cacheable(value= "itemCache", key= "#id")
	public Item getById(int id) {
		return repo.findById(id).get();
	}

	@Override	
	@Caching(
		put= { @CachePut(value= "itemCache", key= "#item.id") },
		evict= { 
				@CacheEvict(value= "pedidoCache", key= "#item.pedido.id"),
				@CacheEvict(value= "allItemsCache", allEntries= true),
				@CacheEvict(value= "allPedidosCache", allEntries= true)
		}
	)
	public Item add(Item item) {
		return repo.save(item);
	}

	@Override	
	@Caching(
		put= { @CachePut(value= "itemCache", key= "#item.id") },
		evict= { 
				@CacheEvict(value= "pedidoCache", key= "#item.pedido.id"),
				@CacheEvict(value= "allItemsCache", allEntries= true),
				@CacheEvict(value= "allPedidosCache", allEntries= true)
		}
	)
	public Item update(Item item) {
		return repo.save(item);
	}

	@Override	
	@Caching(
		evict= { 
			@CacheEvict(value= "itemCache", key= "#id"),
			@CacheEvict(value= "pedidoCache", key= "#item.pedido.id"),
			@CacheEvict(value= "allItemsCache", allEntries= true),
			@CacheEvict(value= "allPedidosCache", allEntries= true)
		}
	)
	public void delete(int id) {
		repo.delete(repo.findById(id).get());	
		
	}

}

package br.com.fiap.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import br.com.fiap.entity.Cliente;
import br.com.fiap.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private ClienteRepository repo;
	
	@Override
	@Cacheable(value= "allClientesCache", unless= "#result.size() == 0")	
	public List<Cliente> getAll() {
		List<Cliente> list = new ArrayList<>();
		repo.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override	
	@Cacheable(value= "clienteCache", key= "#id")	
	public Cliente getById(int id) {
		Optional<Cliente> opt = repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override	
	@Caching(
		put= { @CachePut(value= "clienteCache", key= "#cliente.id") },
		evict= { @CacheEvict(value= "allClientesCache", allEntries= true) }
	)
	public Cliente add(Cliente cliente) {
		return repo.save(cliente);
	}

	@Override	
	@Caching(
		put= { @CachePut(value= "clienteCache", key= "#cliente.id") },
		evict= { @CacheEvict(value= "allClientesCache", allEntries= true) }
	)
	public Cliente update(Cliente cliente) {
		return repo.save(cliente);
	}

	@Override	
	@Caching(
		evict= { 
			@CacheEvict(value= "clienteCache", key= "#id"),
			@CacheEvict(value= "allClientesCache", allEntries= true)
		}
	)
	public void delete(int id) {
		repo.delete(repo.findById(id).get());	
		
	}
		
}

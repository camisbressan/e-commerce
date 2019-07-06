package br.com.fiap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import br.com.fiap.entity.Endereco;
import br.com.fiap.repository.EnderecoRepository;

@Service
public class EnderecoService implements IEnderecoService{

	@Autowired
	private EnderecoRepository repo;
	
	@Override
	@Cacheable(value= "allEnderecosCache", unless= "#result.size() == 0")
	public List<Endereco> getAll() {
		List<Endereco> list = new ArrayList<>();
		repo.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	@Cacheable(value= "enderecoCache", key= "#id")
	public Endereco getById(int id) {
		return repo.findById(id).get();
	}

	@Override	
	@Caching(
		put= { @CachePut(value= "enderecoCache", key= "#endereco.id") },
				evict= { 
						@CacheEvict(value= "clienteCache", key="#endereco.cliente.id"),
						@CacheEvict(value= "allClientesCache", allEntries= true),
						@CacheEvict(value= "allEnderecosCache", allEntries= true)
				}
	)
	public Endereco add(Endereco endereco) {
		return repo.save(endereco);
	}

	@Override	
	@Caching(
		put= { @CachePut(value= "enderecoCache", key= "#id") },
		evict= { 
				@CacheEvict(value= "clienteCache", key="#endereco.cliente.id"),
				@CacheEvict(value= "allClientesCache", allEntries= true),
				@CacheEvict(value= "allEnderecosCache", allEntries= true)
		}
	)
	public Endereco update(Endereco endereco) {
		return repo.save(endereco);
	}

	@Override	
	@Caching(
		evict= { 
			
			@CacheEvict(value= "clienteCache", allEntries= true),
			@CacheEvict(value= "enderecoCache", key= "#id"),
			@CacheEvict(value= "allClientesCache", allEntries= true),
			@CacheEvict(value= "allEnderecosCache", allEntries= true)
		}
	)
	public void delete(int id) {
		repo.delete(repo.findById(id).get());	
	}
}

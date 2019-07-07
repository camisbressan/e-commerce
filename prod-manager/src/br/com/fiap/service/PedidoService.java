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
import br.com.fiap.entity.Pedido;
import br.com.fiap.repository.PedidoRepository;

@Service
public class PedidoService implements IPedidoService {

	@Autowired
	private PedidoRepository repo;
	
	@Override
	@Cacheable(value= "allPedidosCache", unless= "#result.size() == 0")
	public List<Pedido> getAll() {
		List<Pedido> list = new ArrayList<>();
		repo.findAll().forEach(e -> list.add(e));
		return list;
	}
	
	@Override
	@Cacheable(value= "allClientePedidosCache", key= "#cliente.id", unless= "#result.size() == 0")
	public List<Pedido> getAllByCliente(Cliente cliente) {
		List<Pedido> list = new ArrayList<>();
		repo.findPedidoByClienteId(cliente.getId()).forEach(e -> list.add(e));
		return list;
	}

	@Override
	@Cacheable(value= "pedidoCache", key= "#id")
	public Pedido getById(int id) {
		Optional<Pedido> opt = repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override	
	@Caching(
		put= { @CachePut(value= "pedidoCache", key= "#pedido.pedidoPK.codigo") },
		evict= { 
				@CacheEvict(value= "clienteCache", key="#pedido.cliente.id"),
				@CacheEvict(value= "allClientesCache", allEntries= true),
				@CacheEvict(value= "allPedidosCache", allEntries= true) 
		}
	)
	public Pedido add(Pedido pedido) {
		return repo.save(pedido);
	}

	@Override	
	@Caching(
		put= { @CachePut(value= "pedidoCache", key= "#pedido.pedidoPK.codigo") },
		evict= { 
				@CacheEvict(value= "clienteCache", key="#pedido.cliente.id"),
				@CacheEvict(value= "allClientesCache", allEntries= true),
				@CacheEvict(value= "allPedidosCache", allEntries= true) 
		}
	)
	public Pedido update(Pedido pedido) {
		return repo.save(pedido);
	}

	@Override	
	@Caching(
		evict= { 
			@CacheEvict(value= "pedidoCache", key= "#pedido.pedidoPK.codigo"),
			@CacheEvict(value= "clienteCache", key="#pedido.cliente.id"),
			@CacheEvict(value= "allPedidosCache", allEntries= true)
		}
	)
	public void delete(Pedido pedido) {
		repo.delete(pedido);	
		
	}

}

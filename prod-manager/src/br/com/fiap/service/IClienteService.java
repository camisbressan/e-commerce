package br.com.fiap.service;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface IClienteService {
		List<Cliente> getAll();		
		Cliente getById(int id);
		Cliente add(Cliente cliente);
		Cliente update(Cliente cliente);
		void delete(int id);	
}

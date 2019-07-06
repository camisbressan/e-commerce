package br.com.fiap.service;

import java.util.List;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

public interface IPedidoService {
	List<Pedido> getAll();
	List<Pedido> getAllByCliente(Cliente cliente);
	Pedido getById(int id);	
	Pedido add(Pedido pedido);
	Pedido update(Pedido pedido);
	void delete(Pedido pedido);
}

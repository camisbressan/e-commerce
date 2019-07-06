package br.com.fiap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.fiap.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
	
	@Query("select p from pedidos p where p.cliente.id = :clienteId")
	public List<Pedido> findPedidoByClienteId(@Param("clienteId") Integer clienteId);
}

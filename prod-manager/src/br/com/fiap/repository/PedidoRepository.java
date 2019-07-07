package br.com.fiap.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.fiap.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
	
	@Query("select p from pedidos p where p.cliente.id = :clienteId")
	public List<Pedido> findPedidoByClienteId(@Param("clienteId") Integer clienteId);
	
	@Query("select p from pedidos p where p.pedidoPK.codigo = :codigo")
	public Optional<Pedido>  findByCodigo(@Param("codigo") Integer codigo);

	@Override
	default Optional<Pedido> findById(Integer id) {
		return this.findByCodigo(id);
	}
	

}

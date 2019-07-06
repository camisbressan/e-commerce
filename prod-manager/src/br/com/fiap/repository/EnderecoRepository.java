package br.com.fiap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.fiap.entity.Endereco;


public interface EnderecoRepository extends CrudRepository <Endereco, Integer>{
	
	/** Query via JPA **/
	@Query("select e from enderecos e where e.cliente.id = :clienteId")
	public List<Endereco> findByClienteId(@Param("clienteId") Integer clienteId);
	
	@Query("select e from enderecos e where e.cliente.id = :clienteId and e.id = :endId")
	public Endereco findEnderecoByClienteId(@Param("clienteId") Integer clienteId, @Param("endId") Integer endId);
}

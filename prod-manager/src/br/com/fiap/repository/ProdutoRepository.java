package br.com.fiap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.fiap.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
	/** Query via JPA **/
	@Query("select p from Produto p where p.nome = :nome")
	public List<Produto> findByName(@Param("nome") String nome);
}
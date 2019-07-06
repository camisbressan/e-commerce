package br.com.fiap.service;

import java.util.List;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;

public interface IEnderecoService {
	List<Endereco> getAll();
	List<Endereco> getByCliente(Cliente cliente);
	Endereco getById(int id);
	Endereco getById(Cliente cliente, int id);
	Endereco add(Endereco endereco);
	Endereco update(Endereco endereco);
	void delete(Endereco endereco);
}

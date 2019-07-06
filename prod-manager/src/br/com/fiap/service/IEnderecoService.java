package br.com.fiap.service;

import java.util.List;

import br.com.fiap.entity.Endereco;;

public interface IEnderecoService {
	List<Endereco> getAll();		
	Endereco getById(int id);
	Endereco add(Endereco endereco);
	Endereco update(Endereco endereco);
	void delete(int id);
}

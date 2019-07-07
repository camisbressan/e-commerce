package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produtos") 
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5617163065398582043L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOME", length = 120)
	private String nome;
	
	@Column(name = "QUANTIDADE", columnDefinition="int(10)", nullable  = false)
	@org.hibernate.annotations.ColumnDefault("0")
	private Integer quantidade = 0;
	
	@Column(name = "VALOR", columnDefinition="Decimal(10,2)", nullable  = false)
	@org.hibernate.annotations.ColumnDefault("0.0")
	private Double valor = 0.0;

	public Produto() {
	}

	public Produto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Produto(String nome, int quantidade, double valor) {
		this.id = 0L;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public Produto(Long id, String nome, int quantidade, double valor) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Produto (id: " + id + ", nome: " + nome + ")";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
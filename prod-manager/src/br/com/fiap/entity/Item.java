package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "itens")
public class Item implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 137678861974796145L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "QUANTIDADE", columnDefinition="int(10)", nullable  = false)
	private int quantidade;
	
	@Column(name = "VALOR_UNITARIO", columnDefinition="Decimal(10,2)", nullable  = false)
	@org.hibernate.annotations.ColumnDefault("0.0")
	private double valor;
	
	@Column(name = "VALOR_TOTAL", columnDefinition="Decimal(10,2)", nullable  = false)
	@org.hibernate.annotations.ColumnDefault("0.0")
	private double valorTotal;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "NUM_PEDIDO", referencedColumnName = "NUM_PEDIDO"),
		@JoinColumn(name = "CATEGORIA", referencedColumnName = "CATEGORIA") 
	})
	@JsonBackReference
	private Pedido pedido;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
package br.com.fiap.http;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.service.ClienteService;
import br.com.fiap.service.EnderecoService;

public class PurchaseOrder {

	@JsonProperty(required = true)
	private int clienteId;

	@JsonProperty(required = true)
	private int enderecoEntregaId;

	private Cliente cliente;

	private Endereco enderecoEntrega;

	@JsonProperty(required = true)
	private List<ProductOrder> produtos;

	public PurchaseOrder() {
		this.cliente = null;
		this.enderecoEntrega = null;
		this.clienteId = 0;
		this.enderecoEntregaId = 0;
	}

	public PurchaseOrder(int clienteId, int enderecoEntrega, List<ProductOrder> produtos) {
		this.setEnderecoEntregaId(enderecoEntrega);
		this.setClienteId(clienteId);
		this.produtos = produtos;
	}

	public int getClienteId() {

		return clienteId;
	}

	@JsonSetter("clienteId")
	public void setClienteId(int clienteId) {
		ClienteService cliSrv = new ClienteService();
		this.cliente = cliSrv.getById(clienteId);
		this.clienteId = clienteId;
	}

	@JsonSetter("enderecoEntregaId")
	public int getEnderecoEntregaId() {
		return enderecoEntregaId;
	}

	public void setEnderecoEntregaId(int enderecoEntregaId) {
		EnderecoService eSrv = new EnderecoService();
		this.enderecoEntrega = eSrv.getById(enderecoEntregaId);
		this.enderecoEntregaId = enderecoEntregaId;
	}

	public List<ProductOrder> getListaProdutos() {
		return produtos;
	}

	@JsonSetter("produtos")
	public void setListaProdutos(List<ProductOrder> listaProdutos) {
		this.produtos = listaProdutos;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Endereco getEnderecoEntrega() {
		return this.enderecoEntrega;
	}

	public boolean hasCliente() {
		return (this.cliente != null);
	}

	public boolean hasEnderecoEntrega() {
		return (this.enderecoEntrega != null);
	}
}

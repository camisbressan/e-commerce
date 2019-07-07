package br.com.fiap.http;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.service.IClienteService;
import br.com.fiap.service.IEnderecoService;
import br.com.fiap.service.IProdutoService;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class PurchaseOrder {

	@JsonIgnore
	private int clienteId;

	@JsonIgnore
	private int enderecoEntregaId;

	@JsonIgnore
	private Cliente cliente;

	@JsonIgnore
	private Endereco enderecoEntrega;

	@JsonIgnore
	private List<ProductOrder> produtos;

	@JsonIgnore
	private IClienteService cliService;

	@JsonIgnore
	private IEnderecoService enderecoService;

	public PurchaseOrder() {
		this.cliente = null;
		this.enderecoEntrega = null;
		this.clienteId = 0;
		this.enderecoEntregaId = 0;
	}

	@JsonCreator
	public PurchaseOrder(@JsonProperty("clienteId") int clienteId,
			@JsonProperty("enderecoEntregaId") int enderecoEntregaId) {
		this.setClienteId(clienteId);
		this.setEnderecoEntregaId(enderecoEntregaId);
		this.produtos = null;
	}

	@JsonGetter("clienteId")
	public int getClienteId() {
		return clienteId;
	}

	@JsonSetter("clienteId")
	public void setClienteId(int clienteId) {
		this.loadCliente(clienteId);
		this.clienteId = clienteId;
	}

	@JsonGetter("enderecoEntregaId")
	public int getEnderecoEntregaId() {
		return enderecoEntregaId;
	}

	@JsonSetter("enderecoEntregaId")
	public void setEnderecoEntregaId(int enderecoEntregaId) {
		this.loadEndereco(enderecoEntregaId);
		this.enderecoEntregaId = enderecoEntregaId;
	}

	@JsonGetter("produtos")
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

	public void setService(IClienteService cliService, IEnderecoService enderecoService, IProdutoService prodService) {
		this.cliService = cliService;
		this.enderecoService = enderecoService;
		this.loadCliente(clienteId);
		this.loadEndereco(enderecoEntregaId);
		this.loadProdutos(prodService);
	}

	private void loadCliente(int clienteId) {
		try {
			if (null == cliService)
				return;
			this.cliente = cliService.getById(clienteId);
		} catch (Exception e) {
			System.out.println("load cliente [" + e.getMessage() + "]");
		}
	}

	private void loadEndereco(int enderecoEntregaId) {
		try {
			if (null == enderecoService)
				return;
			this.enderecoEntrega = enderecoService.getById(enderecoEntregaId);
		} catch (Exception e) {
			System.out.println("load endere entrega [" + e.getMessage() + "]");
		}
	}
	private void loadProdutos(IProdutoService prodService) {
		if(null == this.produtos) {
			return;
		}
		produtos.forEach(item->{
			System.out.println(item);
			item.setProdutoService(prodService);
		});
	}
	
}

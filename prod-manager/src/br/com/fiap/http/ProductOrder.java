package br.com.fiap.http;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import br.com.fiap.entity.Produto;
import br.com.fiap.service.IProdutoService;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class ProductOrder {

	@JsonIgnore
	private long produtoId;

	@JsonIgnore
	private int quantidade;

	@JsonIgnore
	private Produto produto;

	@JsonIgnore
	private IProdutoService prodService;

	public ProductOrder() {
		this.produto = null;
		this.quantidade = 0;
		this.produtoId = 0;
	}

	@JsonCreator
	public ProductOrder(@JsonProperty("produtoId") long produtoId, @JsonProperty("quantidade") int quantidade) {
		this.setQuantidade(quantidade);
		this.setProdutoId(produtoId);
	}

	@JsonGetter("produtoId")
	public long getProdutoId() {
		return produtoId;
	}

	@JsonSetter("produtoId")
	public void setProdutoId(long produtoId) {
		this.loadProduto(produtoId);
		this.produtoId = produtoId;
	}

	public double getValorTotal() {

		if (this.hasProduto()) {
			return this.produto.getValor() * this.quantidade;
		}
		return 0.0;
	}

	public double getValor() {

		if (this.hasProduto()) {
			return this.produto.getValor();
		}
		return 0.0;
	}

	@JsonGetter("quantidade")
	public int getQuantidade() {
		return quantidade;
	}

	@JsonSetter("quantidade")
	public void setQuantidade(int quantidade) {
		short value = (short) Integer.min(128, Integer.max(quantidade, 1));
		this.quantidade = Short.toUnsignedInt(value);
	}
	
	public void setProdutoService(IProdutoService prodService) {
		this.prodService = prodService;
		this.loadProduto(produtoId);
	}

	private void loadProduto(long produtoId) {
		if(null == prodService)
		{
			return;
		}
		try {
			this.produto = prodService.getProdutoById(produtoId);

		} catch (Exception e) {
			System.out.println("get produto [" + e.getMessage() + "]");
		}
	}

	public Produto getProduto() {
		return this.produto;
	}

	public boolean hasProduto() {
		return (this.produto != null && produto.getQuantidade() > 0 && produto.getValor() > 0.0);
	}

}

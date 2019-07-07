package br.com.fiap.http;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.fiap.entity.Produto;
import br.com.fiap.service.ProdutoService;

public class ProductOrder {
	
	@JsonProperty(required = true)
	private long produtoId;

	@JsonProperty(required = true)
	private int quantidade;

	private Produto produto;

	public long getProdutoId() {
		return produtoId;
	}

	public ProductOrder() {
		this.produto = null;
		this.quantidade = 0;
		this.produtoId = 0;
	}

	public ProductOrder(long produtoId, int quantidade) {
		this.setQuantidade(quantidade);
		this.setProdutoId(produtoId);
	}

	public void setProdutoId(long produtoId) {
		produto = this.loadProduto(produtoId);

		this.produtoId = (produto != null) ? produtoId : 0;
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		short value = (short) Integer.max(quantidade, 128);
		this.quantidade = Short.toUnsignedInt(value);
	}

	private Produto loadProduto(long produtoId) {
		ProdutoService pSrv = new ProdutoService();
		return pSrv.getProdutoById(produtoId);
	}

	public Produto getProduto() {
		return this.produto;
	}

	public boolean hasProduto() {
		return (this.produto != null && produto.getQuantidade() > 0 && produto.getValor() > 0.0);
	}

}

package br.com.fiap.controller;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Item;
import br.com.fiap.entity.Pedido;
import br.com.fiap.http.ProductOrder;
import br.com.fiap.http.PurchaseOrder;
import br.com.fiap.pk.PedidosPK;
import br.com.fiap.service.IClienteService;
import br.com.fiap.service.IEnderecoService;
import br.com.fiap.service.IPedidoService;
import br.com.fiap.service.IProdutoService;

@RestController
@RequestMapping("pedido")
public class PedidoController {
	@Autowired
	private IClienteService cliService;

	@Autowired
	private IEnderecoService enderecoService;

	@Autowired
	private IPedidoService pedidoService;
	
	@Autowired
	private IProdutoService prodService;
	
	@GetMapping("{id}")
	public ResponseEntity<Pedido> getById(@PathVariable("id") int id) {
		Pedido p = pedidoService.getById(id);
		if (null != p) {
			return new ResponseEntity<Pedido>(p, HttpStatus.OK);
		}
		return new ResponseEntity<Pedido>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("cliente/{id}")
	public ResponseEntity<List<Pedido>> getByClienteId(@PathVariable("id") int id) {
		Cliente c = cliService.getById(id);
		if (c == null) {
			return new ResponseEntity<List<Pedido>>(HttpStatus.NOT_ACCEPTABLE);
		}

		List<Pedido> l = pedidoService.getAllByCliente(c);

		return new ResponseEntity<List<Pedido>>(l, l.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}
	
	@PostMapping("comprar")
	public ResponseEntity<Pedido> addPedido(@RequestBody PurchaseOrder p) {
				
		p.setService(cliService, enderecoService, prodService);
		Pedido pedido = new Pedido();
		pedido.setCliente(p.getCliente());
		Calendar cal = Calendar.getInstance();
		pedido.setDataPedido(cal.getTime());
		pedido.setItens(this.createItems(pedido, p));
		PedidosPK pk = new PedidosPK();
		pk.setCategoria("virtual Store");
		Long codigo = Math.round(Math.random() * 1000);
		pk.setCodigo(codigo.intValue());
		pedido.setPedidoPK(pk);
		
		Pedido rs = pedidoService.add(pedido);
		
		return new ResponseEntity<Pedido>(rs, HttpStatus.OK);
	}
	
	private Set<Item> createItems(Pedido pedido, PurchaseOrder p) {
		List<ProductOrder> l = p.getListaProdutos();
		Set<Item> items = new HashSet<>();
		if(l == null) {
			return items;
		}
		l.forEach((item) -> {
			Item i = new Item();
			i.setId(0);
			i.setPedido(pedido);
			i.setQuantidade(item.getQuantidade());
			i.setValor(item.getValor());
			i.setValorTotal(item.getValorTotal());
			items.add(i);
		});
		
		return items;
	}
		
	
}

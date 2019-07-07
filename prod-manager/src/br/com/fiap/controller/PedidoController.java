package br.com.fiap.controller;

import java.util.List;

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
import br.com.fiap.entity.Pedido;
import br.com.fiap.http.PurchaseOrder;
import br.com.fiap.service.IClienteService;
import br.com.fiap.service.IEnderecoService;
import br.com.fiap.service.IPedidoService;

@RestController
@RequestMapping("pedido")
public class PedidoController {
	@Autowired
	private IClienteService cliService;

	@Autowired
	private IEnderecoService enderecoService;

	@Autowired
	private IPedidoService pedidoServece;
	
	@GetMapping("{id}")
	public ResponseEntity<Pedido> getById(@PathVariable("id") int id) {
		Pedido p = pedidoServece.getById(id);
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

		List<Pedido> l = pedidoServece.getAllByCliente(c);

		return new ResponseEntity<List<Pedido>>(l, l.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}
	
	@PostMapping("comprar")
	public ResponseEntity<PurchaseOrder> addPedido(@RequestBody PurchaseOrder p) {
		
		return new ResponseEntity<PurchaseOrder>(p, HttpStatus.OK);
	}
}

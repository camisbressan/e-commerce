package br.com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.service.IClienteService;
import br.com.fiap.service.IEnderecoService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	private IClienteService cliService;
	
	@Autowired
	private IEnderecoService enderecoService;
	
	@GetMapping("{id}")
	public ResponseEntity<Cliente> getById(@PathVariable("id") int id) {
		Cliente cli = cliService.getById(id);
		if(null != cli) {
			return new ResponseEntity<Cliente>(cli, HttpStatus.OK);
		}		
		return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> getAll() {
		List<Cliente> l = cliService.getAll();
		return new ResponseEntity<List<Cliente>>(l, l.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK );
	}
	
	@PostMapping("adicionar")
	public ResponseEntity<Void> addCli(@RequestBody Cliente cliente, UriComponentsBuilder builder) {
		
		Cliente c = cliService.add(cliente);
		if(c != null && c.getId() > 0) {
			HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("{id}").buildAndExpand(c.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	@PutMapping("atualizar")
	public ResponseEntity<Cliente> updateCli(@RequestBody Cliente cliente) {
		Cliente c = cliService.update(cliente);
		if(null != c) {
			return new ResponseEntity<Cliente>(c, HttpStatus.OK);
		}		
		return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteCli(@PathVariable("id") int id) {
		cliService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
  /*
   * Endereço do cliente
   */
	
	@PostMapping("{id}/endereco/adicionar")
	public ResponseEntity<Void> addCliEndereco(@PathVariable("id") int id, @RequestBody Endereco endereco, UriComponentsBuilder builder) {
		
		Cliente c = cliService.getById(id);
		if(c == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		endereco.setCliente(c);
		Endereco ed = enderecoService.add(endereco);
		if(ed != null ) {
			HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("{id}/endereco/{endId").buildAndExpand(c.getId(), ed.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	@PutMapping("{id}/endereco/{endId}")
	public ResponseEntity<Endereco> updateCliEndereco(@PathVariable("id") int id, @PathVariable("endId") int endId, @RequestBody Endereco endereco) {
		
		Cliente c = cliService.getById(id);
		if(c == null) {
			return new ResponseEntity<Endereco>(HttpStatus.NOT_ACCEPTABLE);
		}
		Endereco ed = enderecoService.update(endereco);
		if(ed != null ) {
			
            return new ResponseEntity<Endereco>(ed, HttpStatus.OK);
		}
		return new ResponseEntity<Endereco>(HttpStatus.NO_CONTENT);
		
	}
	
	@DeleteMapping("{id}/endereco/{endId}")
	public ResponseEntity<Void> deleteCli(@PathVariable("id") int id, @PathVariable("endId") int endId) {
		
		Cliente c = cliService.getById(id);
		if(c == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		enderecoService.delete(endId);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
}

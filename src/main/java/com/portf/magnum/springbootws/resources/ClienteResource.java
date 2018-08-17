package com.portf.magnum.springbootws.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portf.magnum.springbootws.domain.Cliente;
import com.portf.magnum.springbootws.service.ClienteService;
import com.portf.magnum.springbootws.service.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		
		List<Cliente> clientes = clienteService.listar();
		return ResponseEntity.ok().body(clientes);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) throws ObjectNotFoundException {
		Cliente cliente = clienteService.find(id);
		return ResponseEntity.ok().body(cliente);
	}

}

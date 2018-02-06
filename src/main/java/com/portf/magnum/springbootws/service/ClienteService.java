package com.portf.magnum.springbootws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portf.magnum.springbootws.domain.Cliente;
import com.portf.magnum.springbootws.repository.ClienteRepository;
import com.portf.magnum.springbootws.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	public Cliente buscar(Integer id) {
		Cliente cliente = clienteRepository.findOne(id);
		if(cliente == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id);
		}
		return cliente;
	}
	
	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);
	}

}

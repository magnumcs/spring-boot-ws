package com.portf.magnum.springbootws.service;

import java.util.List;

import com.portf.magnum.springbootws.domain.Categoria;
import com.portf.magnum.springbootws.dto.ClienteDTO;
import com.portf.magnum.springbootws.service.exception.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort.Direction;

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
	
	public Cliente find(Integer id) {
		Cliente cliente = clienteRepository.findOne(id);
		if(cliente == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id);
		}
		return cliente;
	}

	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		return clienteRepository.save(cliente);
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return clienteRepository.save(newObj);
	}
	public void delete(Integer id) {
		find(id);
		try {
			clienteRepository.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

}

package com.portf.magnum.springbootws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portf.magnum.springbootws.domain.Categoria;
import com.portf.magnum.springbootws.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
	public Categoria buscar(Integer id) {
		return categoriaRepository.findOne(id);
	}
	
	public void salvar(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

}

package com.portf.magnum.springbootws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portf.magnum.springbootws.domain.Categoria;
import com.portf.magnum.springbootws.repository.CategoriaRepository;
import com.portf.magnum.springbootws.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
	public Categoria find(Integer id) {
		Categoria categoria = categoriaRepository.findOne(id);
		if(categoria == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id);
		}
		return categoria;
	}
	
	public Categoria insert(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}

	public Categoria update(Categoria categoria) {
		find(categoria.getId());
		return categoriaRepository.save(categoria);
	}
}

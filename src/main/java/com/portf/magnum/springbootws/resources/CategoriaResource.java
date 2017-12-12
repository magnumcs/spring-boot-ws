package com.portf.magnum.springbootws.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portf.magnum.springbootws.domain.Categoria;
import com.portf.magnum.springbootws.service.CategoriaService;
import com.portf.magnum.springbootws.service.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		
		List<Categoria> categorias = categoriaService.listar();
		return ResponseEntity.ok().body(categorias);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) throws ObjectNotFoundException {
		Categoria categoria = categoriaService.buscar(id);
		return ResponseEntity.ok().body(categoria);
	}

}

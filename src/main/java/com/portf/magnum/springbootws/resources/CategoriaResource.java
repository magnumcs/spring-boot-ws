package com.portf.magnum.springbootws.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.portf.magnum.springbootws.domain.Categoria;
import com.portf.magnum.springbootws.service.CategoriaService;
import com.portf.magnum.springbootws.service.exception.ObjectNotFoundException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria categoria) {
		categoria = categoriaService.insert(categoria);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").
				buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}

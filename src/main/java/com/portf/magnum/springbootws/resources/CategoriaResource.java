package com.portf.magnum.springbootws.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portf.magnum.springbootws.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		
		List<Categoria> categorias = new ArrayList<>();
		
		Categoria c1 = new Categoria(1, "Informática");
		Categoria c2 = new Categoria(2, "Escritório");
		
		categorias.add(c1);
		categorias.add(c2);
		
		return categorias;
		
	}

}

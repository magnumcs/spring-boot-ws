package com.portf.magnum.springbootws;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.portf.magnum.springbootws.domain.Categoria;
import com.portf.magnum.springbootws.domain.Produto;
import com.portf.magnum.springbootws.repository.CategoriaRepository;
import com.portf.magnum.springbootws.repository.ProdutoRepository;

@SpringBootApplication
public class SpringBootWsApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressoa", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1, c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		
		categoriaRepository.save(Arrays.asList(c1, c2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
	}
	
}

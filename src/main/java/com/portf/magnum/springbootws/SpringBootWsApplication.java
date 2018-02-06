package com.portf.magnum.springbootws;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.portf.magnum.springbootws.domain.Categoria;
import com.portf.magnum.springbootws.domain.Cidade;
import com.portf.magnum.springbootws.domain.Cliente;
import com.portf.magnum.springbootws.domain.Endereco;
import com.portf.magnum.springbootws.domain.Estado;
import com.portf.magnum.springbootws.domain.Produto;
import com.portf.magnum.springbootws.enums.TipoClienteEnum;
import com.portf.magnum.springbootws.repository.CategoriaRepository;
import com.portf.magnum.springbootws.repository.CidadeRepository;
import com.portf.magnum.springbootws.repository.ClienteRepository;
import com.portf.magnum.springbootws.repository.EnderecoRepository;
import com.portf.magnum.springbootws.repository.EstadoRepository;
import com.portf.magnum.springbootws.repository.ProdutoRepository;

@SpringBootApplication
public class SpringBootWsApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressoa", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Londres");
		
		Cidade c1 = new Cidade(null, "Viçosa", est1);
		Cidade c2 = new Cidade(null, "Grarulhos", est2);
		Cidade c3 = new Cidade(null, "Cidade de Londres", est3);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2));
		
		estadoRepository.save(Arrays.asList(est1, est2, est3));
		cidadeRepository.save(Arrays.asList(c1, c2,c3));
		
		Cliente cliente1 = new Cliente(null, "Harry Potter", "hpbruxo@gmail.com", "000.000.000-00", TipoClienteEnum.PESSOA_FISICA);
		//cliente1.setTelefones(Stream.of("00000-0000", "11111-1111").collect(Collectors.toSet()));
		
		Endereco end1 = new Endereco(null, "Rua dos alfeneiros", "10", "Sem complemento", "Bairro Local", "00000-000", cliente1, c3);
		cliente1.getEnderecos().addAll(Arrays.asList(end1));
		cliente1.getTelefones().addAll(Arrays.asList("00000-0000", "11111-1111"));
		
		clienteRepository.save(cliente1);
		enderecoRepository.save(Arrays.asList(end1));
	}
	
}

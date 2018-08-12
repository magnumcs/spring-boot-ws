package com.portf.magnum.springbootws;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.portf.magnum.springbootws.domain.*;
import com.portf.magnum.springbootws.repository.*;
import com.portf.magnum.springbootws.service.exception.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.portf.magnum.springbootws.enums.EstadoPagamentoEnum;
import com.portf.magnum.springbootws.enums.TipoClienteEnum;
import com.portf.magnum.springbootws.service.PedidoService;

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
	
	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private PagamentoService pagamentoService;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
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
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Pedido ped1 = new Pedido(null, format.parse("30/09/2017 10:32"), cliente1, end1);
		Pedido ped2 = new Pedido(null, format.parse("10/10/2017 19:35"), cliente1, end1);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamentoEnum.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamentoEnum.PENDENTE, ped2, format.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);

		cliente1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoService.adicionar(Arrays.asList(ped1, ped2));
		pagamentoService.adicionar(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.save(Arrays.asList(ip1, ip2, ip3));

	}
	
}

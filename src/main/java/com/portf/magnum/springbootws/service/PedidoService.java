package com.portf.magnum.springbootws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portf.magnum.springbootws.domain.Pedido;
import com.portf.magnum.springbootws.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void adicionar(Pedido pedido) {
		pedidoRepository.save(pedido);
	}

}

package com.portf.magnum.springbootws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portf.magnum.springbootws.domain.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido, Integer>{

}

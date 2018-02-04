package com.portf.magnum.springbootws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portf.magnum.springbootws.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}

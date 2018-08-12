package com.portf.magnum.springbootws.repository;

import com.portf.magnum.springbootws.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}

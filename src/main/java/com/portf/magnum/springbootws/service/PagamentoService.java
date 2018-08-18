package com.portf.magnum.springbootws.service;

import com.portf.magnum.springbootws.domain.Pagamento;
import com.portf.magnum.springbootws.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public void adicionar(Iterable<Pagamento> pagamentos) {
        pagamentoRepository.save(pagamentos);
    }

}

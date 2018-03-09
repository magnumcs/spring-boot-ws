package com.portf.magnum.springbootws.domain;

import javax.persistence.Entity;

import com.portf.magnum.springbootws.enums.EstadoPagamentoEnum;

@Entity
public class PagamentoComCartao extends Pagamento{
	
	private static final long serialVersionUID = 1L;

	private Integer numeroParcelas;
	
	public PagamentoComCartao() {
	}
	
	public PagamentoComCartao(Integer id, EstadoPagamentoEnum estadoPagamento, Pedido pedido, Integer numeroParcelas) {
		super(id, estadoPagamento, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	
	
	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
	
}

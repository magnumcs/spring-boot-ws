package com.portf.magnum.springbootws.enums;

public enum EstadoPagamentoEnum {
	
	PENDENTE(0, "Pendente"),
	QUITADO(1, "Quitado"),
	CANCELADO(2,"Cancelado");
	
	private Integer codigo;
	private String descricao;
	
	private EstadoPagamentoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static EstadoPagamentoEnum toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for (EstadoPagamentoEnum estadoPagamento : EstadoPagamentoEnum.values()) {
			if(codigo.equals(estadoPagamento.getCodigo())) {
				return estadoPagamento;
			}
		}
		throw new IllegalArgumentException("Id inválido");
	}
	
}

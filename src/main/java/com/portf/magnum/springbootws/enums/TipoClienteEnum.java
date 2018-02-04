package com.portf.magnum.springbootws.enums;

public enum TipoClienteEnum {
	
	PESSOA_FISICA(0, "Pessoa Física"),
	PESSOA_JURIDICA(1, "Pessoa Jurídica");
	
	private Integer id;
	private String nome;
	
	private TipoClienteEnum(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static TipoClienteEnum toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(TipoClienteEnum tipoCliente : TipoClienteEnum.values()) {
			if(cod.equals(tipoCliente.getId())) {
				return tipoCliente;
			}
		}
		throw new IllegalArgumentException("Id inválido");
	}
	

}

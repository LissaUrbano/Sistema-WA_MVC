package com.gft.wa.model;

public enum CargosFuncionario {
	
	ENGENHEIRO_SOFTWARE("Engenheiro de Software"),
	ENGENHEIRO_DADOS("Engenheiro de Dados"),
	STARTER("Starter"),
	GERENTE_TI("Gerente de TI"),
	GERENTE_SEGURANCA("Gerente de Segurança"),
	GERENTE_TECNICO("Gerente técnico");
	
	private String descricao;
	
	CargosFuncionario(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}

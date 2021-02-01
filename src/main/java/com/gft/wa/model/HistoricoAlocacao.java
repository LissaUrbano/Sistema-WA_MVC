package com.gft.wa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HistoricoAlocacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_alocacao")
	private Funcionario funcionarioAlocacao;
	
	@ManyToOne
	@JoinColumn(name = "vaga_alocacao")
	private Vaga vagaAlocacao;
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionarioAlocacao() {
		return funcionarioAlocacao;
	}

	public void setFuncionarioAlocacao(Funcionario funcionarioAlocacao) {
		this.funcionarioAlocacao = funcionarioAlocacao;
	}

	public Vaga getVagaAlocacao() {
		return vagaAlocacao;
	}

	public void setVagaAlocacao(Vaga vagaAlocacao) {
		this.vagaAlocacao = vagaAlocacao;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricoAlocacao other = (HistoricoAlocacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	} 
	
	
	
}

package com.gft.wa.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "O nome é obrigatório")
	@Size(max =	40, message = "O nome não pode conter mais de 40 caracteres")
	private String nome;
	
	@NotBlank (message = "A matricula é obrigatória")
	@Size(max =	10, message = "A matricula não pode conter mais de 10 caracteres")
	private String matricula;
	
	@Enumerated(EnumType.STRING)
	private CargosFuncionario cargo; 
	
	@NotNull(message = "Data de início é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date inicio_wa;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date termino_wa;
	
	@ManyToOne
	@JoinColumn(name = "alocacao_id")
	private Vaga vaga; 
	
	@ManyToOne
	@JoinColumn(name = "local_de_trabalho_id")
	private Gft localTrabalho;
	
	@ManyToMany
	Collection<Tecnologia> tecnologias;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public CargosFuncionario getCargo() {
		return cargo;
	}
	public void setCargo(CargosFuncionario cargo) {
		this.cargo = cargo;
	}
	public Date getInicio_wa() {
		return inicio_wa;
	}
	public void setInicio_wa(Date inicio_wa) {
		this.inicio_wa = inicio_wa;
	}
	public Date getTermino_wa() {
		return termino_wa;
	}
	public void setTermino_wa(Date termino_wa) {
		this.termino_wa = termino_wa;
	}
	public Vaga getVaga() {
		return vaga;
	}
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	public Gft getLocalTrabalho() {
		return localTrabalho;
	}
	public void setLocalTrabalho(Gft localTrabalho) {
		this.localTrabalho = localTrabalho;
	}
	public Collection<Tecnologia> getTecnologias() {
		return tecnologias;
	}
	public void setTecnologias(Collection<Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	} 

	
}

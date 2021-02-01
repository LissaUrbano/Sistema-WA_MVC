package com.gft.wa.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Vaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "O nome é obrigatório")
	@Size(max =	40, message = "O nome não pode conter mais de 40 caracteres")
	private String nome;
	
	@NotNull(message = "Código da vaga é obrigatório")
	private Long codigo_vaga;

	@NotBlank (message = "Descrição da vaga é obrigatória")
	@Size(max =	400, message = "A descrição não pode conter mais de 400 caracteres")
	private String descricao_vaga;

	@NotNull(message = "Data de abertura da vaga é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date abertura_vaga;
	
	@NotBlank (message = "Projeto é obrigatório")
	private String projeto;
	
	@NotNull(message = "Quantidade de vagas é obrigatória")
	@Column(name = "qtd_vaga")
	private int qtdVaga;
	
	@ManyToMany
	Collection<Tecnologia> tecnologias;
	
	@Enumerated(EnumType.STRING)
	private CargosFuncionario cargo; 

	
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

	public Long getCodigo_vaga() {
		return codigo_vaga;
	}

	public void setCodigo_vaga(Long codigo_vaga) {
		this.codigo_vaga = codigo_vaga;
	}

	public String getDescricao_vaga() {
		return descricao_vaga;
	}

	public void setDescricao_vaga(String descricao_vaga) {
		this.descricao_vaga = descricao_vaga;
	}

	public Date getAbertura_vaga() {
		return abertura_vaga;
	}

	public void setAbertura_vaga(Date abertura_vaga) {
		this.abertura_vaga = abertura_vaga;
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public int getQtdVaga() {
		return qtdVaga;
	}

	public void setQtdVaga(int qtdVaga) {
		this.qtdVaga = qtdVaga;
	}

	public Collection<Tecnologia> getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(Collection<Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
	}

	public CargosFuncionario getCargo() {
		return cargo;
	}

	public void setCargo(CargosFuncionario cargo) {
		this.cargo = cargo;
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
		Vaga other = (Vaga) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

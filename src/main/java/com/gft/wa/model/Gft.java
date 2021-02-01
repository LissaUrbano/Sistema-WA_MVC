package com.gft.wa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Gft {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "O nome é obrigatório")
	@Size(max =	30, message = "O nome não pode conter mais de 30 caracteres")
	private String nome;
	
	@NotBlank (message = "O CEP é obrigatório")
	@Size(max =	10, message = "O CEP não pode conter mais de 10 caracteres")
	private String cep;
	
	@NotBlank (message = "A Cidade é obrigatória")
	@Size(max =	60, message = "A cidade não pode conter mais de 60 caracteres")
	private String cidade;
	
	@NotBlank (message = "O endereço é obrigatório")
	@Size(max =	60, message = "O endereço não pode conter mais de 60 caracteres")
	private String endereco;
	
	@NotBlank (message = "O Estado é obrigatório")
	@Size(max =	60, message = "O estado não pode conter mais de 60 caracteres")
	private String estado;
	
	@NotBlank (message = "O telefone é obrigatório")
	@Size(max =	15, message = "O telefone não pode conter mais de 15 caracteres")
	private String telefone;

	
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		Gft other = (Gft) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

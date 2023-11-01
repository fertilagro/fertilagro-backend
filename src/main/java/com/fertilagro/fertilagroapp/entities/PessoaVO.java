package com.fertilagro.fertilagroapp.entities;

import java.util.Objects;

import com.fertilagro.fertilagroapp.enumerador.StatusEnum;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "pessoa")
public class PessoaVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String razaoSocial;
	private StatusEnum status;
	@Embedded
	Endereco endereco;
	
	public PessoaVO () {
		
	}
	
	public PessoaVO(Integer id, String razaoSocial, StatusEnum status, Endereco endereco) {
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.status = status;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaVO other = (PessoaVO) obj;
		return Objects.equals(id, other.id) && status == other.status;
	}
	
	
	
	
}

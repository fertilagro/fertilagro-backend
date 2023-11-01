package com.fertilagro.fertilagroapp.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cidade")
public class CidadeVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer codigoIbge;
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
	public Integer getCodigoIbge() {
		return codigoIbge;
	}
	public void setCodigoIbge(Integer codigoIbge) {
		this.codigoIbge = codigoIbge;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigoIbge, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CidadeVO other = (CidadeVO) obj;
		return Objects.equals(codigoIbge, other.codigoIbge) && Objects.equals(id, other.id);
	}
	
	
}

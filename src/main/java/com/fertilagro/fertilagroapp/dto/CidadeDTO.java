package com.fertilagro.fertilagroapp.dto;

import com.fertilagro.fertilagroapp.entities.CidadeVO;

public class CidadeDTO {
	private Integer id;
	private String nome;
	private Integer codigoIbge;
	
	
	public CidadeDTO(CidadeVO entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.codigoIbge = entity.getCodigoIbge();
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


	public Integer getCodigoIbge() {
		return codigoIbge;
	}


	public void setCodigoIbge(Integer codigoIbge) {
		this.codigoIbge = codigoIbge;
	}
	
	
}

package com.fertilagro.fertilagroapp.dto;


import com.fertilagro.fertilagroapp.entities.Endereco;
import com.fertilagro.fertilagroapp.entities.PessoaVO;
import com.fertilagro.fertilagroapp.enumerador.StatusEnum;


public class PessoaDTO {
	private Integer id;
	private String razaoSocial;
	private StatusEnum status;	
	private Endereco endereco;
	public PessoaDTO() {
		
	}
	
	public PessoaDTO(PessoaVO entity) {
		this.id = entity.getId();
		this.razaoSocial = entity.getRazaoSocial();
		this.status = entity.getStatus();
		this.endereco = entity.getEndereco();
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

	
}

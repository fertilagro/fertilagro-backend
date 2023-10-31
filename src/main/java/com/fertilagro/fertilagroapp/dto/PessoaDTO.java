package com.fertilagro.fertilagroapp.dto;


import com.fertilagro.fertilagroapp.entities.PessoaVO;


public class PessoaDTO {
	private Integer id;
	private String nome;
	private boolean status;	
	
	public PessoaDTO() {
		
	}
	
	public PessoaDTO(PessoaVO entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.status = entity.isStatus();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public boolean isStatus() {
		return status;
	}
	
}

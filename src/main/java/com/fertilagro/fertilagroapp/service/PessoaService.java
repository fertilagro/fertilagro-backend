package com.fertilagro.fertilagroapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fertilagro.fertilagroapp.entities.PessoaVO;
import com.fertilagro.fertilagroapp.repositorio.PessoaRepositorio;
import com.fertilagro.fertilagroapp.repositorio.SuperRepositorio;

@Service
public class PessoaService extends SuperService<PessoaVO> {

	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	
	public PessoaService(PessoaRepositorio pessoaRepositorio) {
		this.pessoaRepositorio = pessoaRepositorio;
	}
	
	@Override
	protected SuperRepositorio<PessoaVO> getRepositorio() {
		return pessoaRepositorio;
	}

}

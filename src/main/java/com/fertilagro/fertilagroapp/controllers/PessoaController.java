package com.fertilagro.fertilagroapp.controllers;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.dto.PessoaDTO;
import com.fertilagro.fertilagroapp.entities.PessoaVO;
import com.fertilagro.fertilagroapp.service.PessoaService;
import com.fertilagro.fertilagroapp.service.SuperService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController extends SuperController<PessoaVO, PessoaDTO> implements Serializable {

	private static final long serialVersionUID = -555934541255538348L;
	
	@Autowired
	private PessoaService pessoaService;
	
	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@Override
	protected SuperService<PessoaVO> getSuperService() {
		return pessoaService;
	}
}

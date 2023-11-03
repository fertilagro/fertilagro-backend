package com.fertilagro.fertilagroapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.entities.PessoaVO;
import com.fertilagro.fertilagroapp.service.SuperService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController extends SuperController<PessoaVO, Integer> {

	public PessoaController(SuperService<PessoaVO, Integer> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
}

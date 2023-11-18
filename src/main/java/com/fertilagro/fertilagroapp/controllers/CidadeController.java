package com.fertilagro.fertilagroapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.service.SuperService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController extends SuperController<CidadeVO, Integer>{

	public CidadeController(SuperService<CidadeVO, Integer> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
}


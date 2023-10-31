package com.fertilagro.fertilagroapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.entities.PessoaVO;
import com.fertilagro.fertilagroapp.service.PessoaService;

@RestController
@RequestMapping(value ="/pessoa")
public class PessoaController {

	@Autowired 
	private PessoaService pessoaService;

	@GetMapping
	public List<PessoaVO> findAll(){
		List<PessoaVO> result = pessoaService.findAll();
		return result;
 	}
}

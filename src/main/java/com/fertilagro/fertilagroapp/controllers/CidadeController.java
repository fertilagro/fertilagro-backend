package com.fertilagro.fertilagroapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.service.CidadeService;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {

	@Autowired 
	CidadeService cidadeService;
	
	@GetMapping
	public List<CidadeVO> findAll(){
		List<CidadeVO> result = cidadeService.findAll();
		return result;
 	}
}

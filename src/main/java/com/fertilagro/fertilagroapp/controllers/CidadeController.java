package com.fertilagro.fertilagroapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
    @PostMapping("/buscarPorFkField")
    public ResponseEntity<?> buscarPorFkField(@RequestBody String entity) {
         return new ResponseEntity<>(HttpStatus.CREATED);
    }
}


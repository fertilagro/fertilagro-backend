package com.fertilagro.fertilagroapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.repositorio.CidadeRepositorio;
import com.fertilagro.fertilagroapp.service.SuperService;
import com.fertilagro.fertilagroapp.util.uteis;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController extends SuperController<CidadeVO, Integer>{
	
	@Autowired
	private CidadeRepositorio CidadeRepositorio;
	
	public CidadeController(SuperService<CidadeVO, Integer> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
	
    @PostMapping("/buscarPorFkField")
    public ResponseEntity<?> buscarPorFkField(@RequestBody String dados) {
    	CidadeVO cidade = new CidadeVO();
    	if (uteis.ContemSomenteNumero(dados)) {
    		 Integer id = Integer.parseInt(dados);
    		 cidade = CidadeRepositorio.encontrarPorId(id);
    	} else {
    		 cidade = CidadeRepositorio.encontrarPorAtributoPersonalizado(dados);
    	}
    	return new ResponseEntity<>(cidade, HttpStatus.OK);
    }
    
}


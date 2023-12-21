package com.fertilagro.fertilagroapp.controllers;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.dto.CidadeDTO;
import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.service.CidadeService;
import com.fertilagro.fertilagroapp.service.SuperService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController extends SuperController<CidadeVO, CidadeDTO> implements Serializable {

	private static final long serialVersionUID = 1062932981149544270L;
	
	@Autowired
	private CidadeService cidadeService;
	
	public CidadeController(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}
	
	@Override
	protected SuperService<CidadeVO> getSuperControler() {
		return cidadeService;
	}
	
    @PostMapping("/buscarPorFkField")
    public ResponseEntity<Page<CidadeVO>> buscarPorFkField(@RequestBody String dados, Pageable pageable) {
    	Page<CidadeVO> cidades = cidadeService.buscarPorFkField(dados, pageable); 	
    	return new ResponseEntity<>(cidades, HttpStatus.OK);
    }
    
}


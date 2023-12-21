package com.fertilagro.fertilagroapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.dto.AmostraDTO;
import com.fertilagro.fertilagroapp.entities.AmostraVO;
import com.fertilagro.fertilagroapp.service.AmostraService;
import com.fertilagro.fertilagroapp.service.SuperService;

@RestController
@RequestMapping(value = "/amostras")
public class AmostraController extends SuperController<AmostraVO , AmostraDTO>{

	@Autowired
	private AmostraService amostraService;
	
	public AmostraController(AmostraService amostraService) {
		this.amostraService = amostraService;
	}
	@Override
	protected SuperService<AmostraVO> getSuperControler() {
		return amostraService;
	}


}

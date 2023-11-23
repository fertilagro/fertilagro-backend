package com.fertilagro.fertilagroapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.entities.AmostraVO;
import com.fertilagro.fertilagroapp.service.SuperService;

@RestController
@RequestMapping(value = "/amostras")

public class AmostraController  extends SuperController <AmostraVO , Integer>{

	public AmostraController(SuperService<AmostraVO, Integer> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
}

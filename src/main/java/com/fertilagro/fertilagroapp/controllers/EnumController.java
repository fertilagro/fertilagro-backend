package com.fertilagro.fertilagroapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.util.EnumInterface;

@RestController
@RequestMapping(value = "/enums")
public class EnumController {

	@GetMapping()
	private List<EnumInterface> buscarTodos() {
		
		
		
		
		
		return null;
	}
	
}


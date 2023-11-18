package com.fertilagro.fertilagroapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.util.EnumInterface;

@RestController
@RequestMapping(value = "/enums")
public class EnumController {

	@GetMapping()
	private List<EnumInterface> buscarTodos(@RequestParam("nome") String nome) {
		List<EnumInterface> listaEnuns = null;
		var reflections = new Reflections("com.fertilagro.fertilagroapp.enumerador");
		Set<Class<? extends EnumInterface>> todasClasses = reflections.getSubTypesOf(EnumInterface.class);
		
		Class<? extends EnumInterface> enumeradorEnum = null;
		for (Class<? extends EnumInterface> class1 : todasClasses) {
			if(nome.equals(class1.getSimpleName())) {
				enumeradorEnum = class1;
				break;
			}
			
		}
		if(enumeradorEnum != null) {
			listaEnuns = new ArrayList<>();
			for(EnumInterface constant : enumeradorEnum.getEnumConstants()){
				listaEnuns.add(constant);
			}
		}
		return listaEnuns;
	}
	
}


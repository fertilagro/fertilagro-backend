package com.fertilagro.fertilagroapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.repositorio.CidadeRepositorio;

public class CidadeService {
	
	@Autowired
	CidadeRepositorio cidadeRepositorio;
	
	public List<CidadeVO> findAll(){
		List<CidadeVO> result = cidadeRepositorio.findAll();
		return result;
	}
}

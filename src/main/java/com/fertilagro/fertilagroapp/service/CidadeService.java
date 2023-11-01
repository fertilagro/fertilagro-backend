package com.fertilagro.fertilagroapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.repositorio.CidadeRepositorio;

@Service
public class CidadeService {
	
	@Autowired
	CidadeRepositorio cidadeRepositorio;
	
	public List<CidadeVO> findAll(){
		List<CidadeVO> result = cidadeRepositorio.findAll();
		return result;
	}
}

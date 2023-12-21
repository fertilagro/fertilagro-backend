package com.fertilagro.fertilagroapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fertilagro.fertilagroapp.entities.AmostraVO;
import com.fertilagro.fertilagroapp.repositorio.AmostraRepositorio;
import com.fertilagro.fertilagroapp.repositorio.SuperRepositorio;

@Service
public class AmostraService extends SuperService<AmostraVO>{

	@Autowired
	private AmostraRepositorio amostraRepositorio;
	
	public AmostraService(AmostraRepositorio amostraRepositorio) {
		this.amostraRepositorio = amostraRepositorio;
	}
	@Override
	protected SuperRepositorio<AmostraVO> getRepositorio() {
		return amostraRepositorio;
	}

}

package com.fertilagro.fertilagroapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fertilagro.fertilagroapp.entities.SequenciaVO;
import com.fertilagro.fertilagroapp.repositorio.SequenciaRepositorio;
import com.fertilagro.fertilagroapp.repositorio.SuperRepositorio;

@Service
public class SequenciaService extends SuperService<SequenciaVO> {

	@Autowired
	private SequenciaRepositorio sequenciaRepositorio;
	
	public SequenciaService(SequenciaRepositorio sequenciaRepositorio) {
		this.sequenciaRepositorio = sequenciaRepositorio;
	}
	
	@Override
	protected SuperRepositorio<SequenciaVO> getRepositorio() {
		return sequenciaRepositorio;
	}


}

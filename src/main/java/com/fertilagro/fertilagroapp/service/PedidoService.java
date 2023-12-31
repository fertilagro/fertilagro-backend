package com.fertilagro.fertilagroapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fertilagro.fertilagroapp.entities.PedidoVO;
import com.fertilagro.fertilagroapp.repositorio.PedidoRepositorio;
import com.fertilagro.fertilagroapp.repositorio.SuperRepositorio;

@Service
public class PedidoService extends SuperService<PedidoVO> {

	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	@Autowired
	private SequenciaService sequenciaService;
	
	@Override
	protected SequenciaService getSequenciaService() {
		return sequenciaService;
	}

	@Override
	protected SuperRepositorio<PedidoVO> getRepositorio() {
		return pedidoRepositorio;
	}

}

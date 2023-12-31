package com.fertilagro.fertilagroapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.dto.PedidoDTO;
import com.fertilagro.fertilagroapp.entities.PedidoVO;
import com.fertilagro.fertilagroapp.service.PedidoService;
import com.fertilagro.fertilagroapp.service.SuperService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController extends SuperController<PedidoVO, PedidoDTO> {

	@Autowired
	private PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@Override
	protected SuperService<PedidoVO> getSuperService() {
		return pedidoService;
	}
	
}

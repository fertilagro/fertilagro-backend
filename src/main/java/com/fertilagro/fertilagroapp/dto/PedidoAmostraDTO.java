package com.fertilagro.fertilagroapp.dto;

import com.fertilagro.fertilagroapp.dto.pk.EmpresaPedidoAmostraPKDTO;
import com.fertilagro.fertilagroapp.entities.PedidoAmostraVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoAmostraDTO extends SuperDTO<PedidoAmostraVO> {

	private EmpresaPedidoAmostraPKDTO id;
	private PedidoDTO pedido;
	private AmostraDTO amostra;
	
}

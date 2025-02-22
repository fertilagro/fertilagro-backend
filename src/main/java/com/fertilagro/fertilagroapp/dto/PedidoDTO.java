package com.fertilagro.fertilagroapp.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fertilagro.fertilagroapp.dto.pk.EmpresaPadraoIdPKDTO;
import com.fertilagro.fertilagroapp.entities.PedidoVO;
import com.fertilagro.fertilagroapp.enumerador.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO extends SuperDTO<PedidoVO> {

	private EmpresaPadraoIdPKDTO id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	private PessoaDTO pessoa;
	private StatusEnum status;
	
	private List<PedidoAmostraDTO> pedidoAmostras;

}

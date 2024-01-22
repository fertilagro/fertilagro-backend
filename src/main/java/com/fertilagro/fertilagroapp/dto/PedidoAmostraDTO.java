package com.fertilagro.fertilagroapp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fertilagro.fertilagroapp.dto.pk.EmpresaPedidoAmostraPKDTO;
import com.fertilagro.fertilagroapp.entities.PedidoAmostraVO;
import com.fertilagro.fertilagroapp.enumerador.MatrizEnum;

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
	
	private Integer idAmostra;
    private String propriedade;	
    private String nomeCliente;
	private String solicitante;
	private LocalDate entrada;
	private LocalDate saida;
	private String descricaoAmostra;
	private String matriz;
	private String tipoAnalise;
	private BigDecimal valor;
	private String observacao;

}

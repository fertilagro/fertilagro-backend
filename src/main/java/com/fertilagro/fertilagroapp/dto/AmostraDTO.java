package com.fertilagro.fertilagroapp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fertilagro.fertilagroapp.dto.pk.EmpresaPadraoIdPKDTO;
import com.fertilagro.fertilagroapp.entities.AmostraVO;
import com.fertilagro.fertilagroapp.enumerador.AmostraEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AmostraDTO extends SuperDTO<AmostraVO> {
	
	private EmpresaPadraoIdPKDTO id;
	private String propriedade;	
	private PessoaDTO cliente;	
	private String solicitante;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate entrada;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate saida;
	private String descricaoAmostra;
	private AmostraEnum tipoAnalise;
	private BigDecimal valor;
	private String observacao;
	
}

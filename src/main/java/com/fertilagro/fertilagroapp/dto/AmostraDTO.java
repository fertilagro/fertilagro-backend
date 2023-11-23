package com.fertilagro.fertilagroapp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fertilagro.fertilagroapp.enumerador.AmostraEnum;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AmostraDTO {
	private Integer id;
	
	private String propriedade;
	
	private PessoaDTO cliente;
	
	private Integer clienteId;

	private String solicitante;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate entrada;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate saida;
	
	private String descricaoAmostra;
	
	private AmostraEnum tipoAnalise;
	
	private Long numeroPedido;

	private BigDecimal valor;
	
	private String observacao;
	
}

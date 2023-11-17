package com.fertilagro.fertilagroapp.dto;

import com.fertilagro.fertilagroapp.entities.CidadeVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CidadeDTO {
	private Integer id;
	private String nome;
	private Integer codigoIbge;
	
}

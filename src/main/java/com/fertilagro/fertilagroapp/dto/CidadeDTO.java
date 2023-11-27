package com.fertilagro.fertilagroapp.dto;

import com.fertilagro.fertilagroapp.entities.CidadeVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CidadeDTO extends SuperDTO<CidadeVO> {
	
	private Integer id;
	private String nome;
	private Integer codigoIbge;
	private String labelFkfield;
	
	public CidadeDTO() {
		super();
	}
	
	public CidadeDTO toDTOCidade(CidadeVO cidade) {
		return null;
//			new CidadeDTO(
//					cidade.getId(),
//					cidade.getNome(), 
//					cidade.getCodigoIbge());
	}
	
	public CidadeVO toVOCidade (CidadeDTO cidade) {
		return null;
	}
}

package com.fertilagro.fertilagroapp.dto;

import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.enumerador.EstadoEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CidadeDTO extends SuperDTO<CidadeVO> {
	
	private Integer id;
	private String nome;
	private EstadoEnum estado;
	
	public CidadeDTO() {
		super();
	}
	
	public CidadeDTO convertVOparaDTO(CidadeVO cidade) {
		/*CidadeDTO cidadeDTO = new CidadeDTO();
		cidadeDTO.setId(cidade.getId());*/
		return null;
	}
	

}

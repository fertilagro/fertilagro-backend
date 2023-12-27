package com.fertilagro.fertilagroapp.dto;

import com.fertilagro.fertilagroapp.dto.pk.EmpresaPadraoIdPKDTO;
import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.entities.SuperVO;

public abstract class SuperDTO<T extends SuperVO> {
	
	private String labelFkfield;
	
	public SuperDTO() {
    	super();	
	}
	
	public String getLabelFkfield() {
		return labelFkfield;
	}

	public void setLabelFkfield(String labelFkfield) {
		this.labelFkfield = labelFkfield;
	}

	public CidadeDTO convertVOparaDTOCidade(CidadeVO cidade, CidadeDTO cidadeDTO) {
		EmpresaPadraoIdPKDTO id = new EmpresaPadraoIdPKDTO();
		id.setEmpresa(cidade.getId().getEmpresa());
		id.setId(cidade.getId().getId());
		
		cidadeDTO.setId(id);
		cidadeDTO.setNome(cidade.getNome());
		cidadeDTO.setEstado(cidade.getEstado());
		cidadeDTO.setLabelFkfield(cidade.getLabelFkfield());
		return cidadeDTO;
	}
	
}

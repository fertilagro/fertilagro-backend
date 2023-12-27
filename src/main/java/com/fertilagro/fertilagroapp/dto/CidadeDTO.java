package com.fertilagro.fertilagroapp.dto;

import java.util.ArrayList;
import java.util.List;

import com.fertilagro.fertilagroapp.dto.pk.EmpresaPadraoIdPKDTO;
import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.enumerador.EstadoEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CidadeDTO extends SuperDTO<CidadeVO> {
	
	private EmpresaPadraoIdPKDTO id;
	private String nome;
	private EstadoEnum estado;
	private String labelFkfield;
	
	public CidadeDTO() {
		super();
	}
	
	public CidadeDTO convertVOparaDTO(CidadeVO cidade) {
		CidadeDTO cidadeDTO = new CidadeDTO();
		
		EmpresaPadraoIdPKDTO id = new EmpresaPadraoIdPKDTO();
		id.setEmpresa(cidade.getId().getEmpresa());
		id.setId(cidade.getId().getId());
		
		cidadeDTO.setId(id);
		cidadeDTO.setNome(cidade.getNome());
		cidadeDTO.setEstado(cidade.getEstado());
		return cidadeDTO;
	}
	
	public void convertListVOparaDTO(List<CidadeVO> listVO, List<CidadeDTO> listDTO) {
		List<CidadeDTO> cidadesDTO = new ArrayList<CidadeDTO>();
		
		for(CidadeVO list: listVO) {
			EmpresaPadraoIdPKDTO id = new EmpresaPadraoIdPKDTO();
			id.setEmpresa(list.getId().getEmpresa());
			id.setId(list.getId().getId());
			
			CidadeDTO cidade = new CidadeDTO();
			cidade.setId(id);
			cidade.setNome(list.getNome());
			cidade.setEstado(list.getEstado());

			cidadesDTO.add(cidade);
		}
		
		listDTO.addAll(cidadesDTO);
	}
	
	public String getLabelFkfield() {
		return labelFkfield;
	}

	public void setLabelFkfield(String labelFkfield) {
		this.labelFkfield = labelFkfield;
	}
}

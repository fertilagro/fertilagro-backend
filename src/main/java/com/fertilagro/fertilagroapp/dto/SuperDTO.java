package com.fertilagro.fertilagroapp.dto;

import com.fertilagro.fertilagroapp.dto.pk.EmpresaPadraoIdPKDTO;
import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.entities.PedidoVO;
import com.fertilagro.fertilagroapp.entities.PessoaVO;
import com.fertilagro.fertilagroapp.entities.SuperVO;
import com.fertilagro.fertilagroapp.enumerador.StatusEnum;

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
	
	public PedidoDTO convertVOparaDTOPedido(PedidoVO pedido, PedidoDTO pedidoDTO) {
		EmpresaPadraoIdPKDTO id = new EmpresaPadraoIdPKDTO();
		id.setEmpresa(pedido.getId().getEmpresa());
		id.setId(pedido.getId().getId());
		
		pedidoDTO.setId(id);
		pedidoDTO.setLabelFkfield(pedido.getLabelFkfield());
		
		pedidoDTO.setData(pedido.getData());

		PessoaDTO pessoa = new PessoaDTO();
		pedidoDTO.setPessoa(convertVOparaDTOPessoa(pedido.getPessoa(),pessoa));
		pedidoDTO.setStatus(StatusEnum.ATIVO);
		
		//pedidoDTO.
	
		return pedidoDTO;		
	}
	
	public PessoaDTO convertVOparaDTOPessoa(PessoaVO pessoa, PessoaDTO pessoaDTO) {
		EmpresaPadraoIdPKDTO id = new EmpresaPadraoIdPKDTO();
		id.setEmpresa(pessoa.getId().getEmpresa());
		id.setId(pessoa.getId().getId());
		
		pessoaDTO.setId(id);
		pessoaDTO.setLabelFkfield(pessoa.getLabelFkfield());
		
		pessoaDTO.setRazaoSocial(pessoa.getRazaoSocial());
		pessoaDTO.setCnpjCpf(pessoa.getCnpjCpf());
		pessoaDTO.setTelefone(pessoa.getTelefone());
		pessoaDTO.setEmail(pessoa.getEmail());
		pessoaDTO.setEndereco(pessoa.getEndereco());
		
		CidadeDTO cidade = new CidadeDTO();
		pessoaDTO.setCidade(convertVOparaDTOCidade(pessoa.getCidade(),cidade));
		pessoaDTO.setStatus(StatusEnum.ATIVO);
	
		return pessoaDTO;		
	}
	
}

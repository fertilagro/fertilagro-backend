package com.fertilagro.fertilagroapp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fertilagro.fertilagroapp.dto.pk.EmpresaPadraoIdPKDTO;
import com.fertilagro.fertilagroapp.dto.pk.EmpresaPedidoAmostraPKDTO;
import com.fertilagro.fertilagroapp.entities.AmostraVO;
import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.entities.PedidoAmostraVO;
import com.fertilagro.fertilagroapp.entities.PedidoVO;
import com.fertilagro.fertilagroapp.entities.PessoaVO;
import com.fertilagro.fertilagroapp.entities.SuperVO;
import com.fertilagro.fertilagroapp.enumerador.MatrizEnum;
import com.fertilagro.fertilagroapp.enumerador.StatusEnum;

public abstract class SuperDTO<T extends SuperVO> {
	
	private String labelFkfield;
	private Object dataKey;
	
	public SuperDTO() {
    	super();	
	}
	
	public String getLabelFkfield() {
		return labelFkfield;
	}

	public void setLabelFkfield(String labelFkfield) {
		this.labelFkfield = labelFkfield;
	}
	
	public Object getDataKey() {
		return dataKey;
	}

	public void setDataKey(Object dataKey) {
		this.dataKey = dataKey;
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
		
		List<PedidoAmostraDTO> listDTO = new ArrayList<PedidoAmostraDTO>();
		pedidoDTO.setPedidoAmostras(convertListVOparaDTOPedidoAmostra(pedido.getPedidoAmostras(),listDTO));
	
		return pedidoDTO;		
	}
	
	public List<PedidoAmostraDTO> convertListVOparaDTOPedidoAmostra(List<PedidoAmostraVO> pedidosVO,
			List<PedidoAmostraDTO> pedidosDTO) {
		
		for (PedidoAmostraVO listaVO: pedidosVO) {
			EmpresaPedidoAmostraPKDTO id = new EmpresaPedidoAmostraPKDTO();
			id.setEmpresa(listaVO.getId().getEmpresa());
			id.setPedido(listaVO.getId().getPedido());
			id.setId(listaVO.getId().getId());
			
			PedidoAmostraDTO pedidoAmDTO = new PedidoAmostraDTO();
			pedidoAmDTO.setId(id);
			pedidoAmDTO.setLabelFkfield(listaVO.getLabelFkfield());
			pedidoAmDTO.setDataKey(listaVO.getId().getEmpresa() + "|" + listaVO.getId().getPedido() + "|" + listaVO.getId().getId());
			
		    //AMOSTRA
		/*	AmostraDTO amostraDTO = new AmostraDTO();
			EmpresaPadraoIdPKDTO idAmostra = new EmpresaPadraoIdPKDTO();
			idAmostra.setEmpresa(listaVO.getAmostra().getId().getEmpresa());
			idAmostra.setId(listaVO.getAmostra().getId().getId());
			amostraDTO.setId(idAmostra);
			amostraDTO.setSolicitante(listaVO.getAmostra().getSolicitante());
			amostraDTO.setDataKey(idAmostra.getEmpresa() + "|" + idAmostra.getId());*/
			
			/*
			 	private String propriedade;	
	private PessoaDTO cliente;	
	private String solicitante;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate entrada;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate saida;
	private String descricaoAmostra;
	private MatrizEnum matriz;
	private BigDecimal valor;
	private String observacao;
			 * */

		//	pedidoAmDTO.setAmostra(amostraDTO);
			
			pedidosDTO.add(pedidoAmDTO);			
		}
		
		
		
	
		return pedidosDTO;		
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
		pessoaDTO.setDataKey(pessoa.getId().getEmpresa()+"|"+pessoa.getId().getId());
	
		return pessoaDTO;		
	}

	public AmostraDTO convertVOparaDTOAmostra(AmostraVO amostra, AmostraDTO amostraDTO) {
		EmpresaPadraoIdPKDTO id = new EmpresaPadraoIdPKDTO();
		id.setEmpresa(amostra.getId().getEmpresa());
		id.setId(amostra.getId().getId());
		amostraDTO.setId(id);
		
		amostraDTO.setLabelFkfield(amostra.getLabelFkfield());
		amostraDTO.setDataKey(amostra.getId().getEmpresa()+"|"+amostra.getId().getId());
		
		amostraDTO.setPropriedade(amostra.getPropriedade());
		PessoaDTO clienteDTO = new PessoaDTO();
		amostraDTO.setCliente(convertVOparaDTOPessoa(amostra.getCliente(),clienteDTO));
		amostraDTO.setSolicitante(amostra.getSolicitante());
		amostraDTO.setEntrada(amostra.getEntrada());
		amostraDTO.setSaida(amostra.getSaida());
		amostraDTO.setDescricaoAmostra(amostra.getDescricaoAmostra());
		amostraDTO.setTipoAnalise(amostra.getTipoAnalise());
		amostraDTO.setValor(amostra.getValor());
		amostraDTO.setObservacao(amostra.getObservacao());
		amostraDTO.setMatriz(amostra.getMatriz());
	
		return amostraDTO;		
	}
}

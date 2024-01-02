package com.fertilagro.fertilagroapp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fertilagro.fertilagroapp.conversor.LocalDateAttributeConverter;
import com.fertilagro.fertilagroapp.dto.pk.EmpresaPadraoIdPKDTO;
import com.fertilagro.fertilagroapp.dto.pk.EmpresaPedidoAmostraPKDTO;
import com.fertilagro.fertilagroapp.entities.AmostraVO;
import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.entities.PedidoAmostraVO;
import com.fertilagro.fertilagroapp.entities.PedidoVO;
import com.fertilagro.fertilagroapp.entities.PessoaVO;
import com.fertilagro.fertilagroapp.entities.SuperVO;
import com.fertilagro.fertilagroapp.enumerador.AmostraEnum;
import com.fertilagro.fertilagroapp.enumerador.StatusEnum;
import com.fertilagro.fertilagroapp.pk.EmpresaPadraoIdPK;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

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
			
			PedidoAmostraDTO pedidoAm = new PedidoAmostraDTO();
			pedidoAm.setId(id);
			
			
			
		/*	private EmpresaPedidoAmostraPKDTO id;
			private PedidoDTO pedido;
			private AmostraDTO amostra;*/

			pedidosDTO.add(pedidoAm);			
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
	
		return pessoaDTO;		
	}

	public AmostraDTO convertVOparaDTOAmostras(AmostraVO amostra, AmostraDTO amostraDTO) {
		EmpresaPadraoIdPKDTO id = new EmpresaPadraoIdPKDTO();
		id.setEmpresa(amostra.getId().getEmpresa());
		id.setId(amostra.getId().getId());
		
		amostraDTO.setId(id);
		
		/*private EmpresaPadraoIdPK id;
		
		@Column(name = "PROPRIEDADE")
		private String propriedade;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumns(value = {
				@JoinColumn(name = "empresa", referencedColumnName = "empresa", insertable = false, updatable = false),
				@JoinColumn(name = "cliente", referencedColumnName = "id", insertable = false, updatable = false)})
		private PessoaVO cliente;
		@Column(name="CLIENTE")
		private Integer clienteId;

		@Column(name = "SOLICITANTE")
		private String solicitante;
		
		@Column(name = "ENTRADA")
		@Convert(converter = LocalDateAttributeConverter.class)
		@JsonFormat(pattern = "yyyy-MM-dd")
		private LocalDate entrada;
		
		@Column(name = "SAIDA")
		@Convert(converter = LocalDateAttributeConverter.class)
		@JsonFormat(pattern = "yyyy-MM-dd")
		private LocalDate saida;
		
		@Column(name = "DESCRICAO_AMOSTRA")
		private String descricaoAmostra;
		
		@Column(name = "TIPO_ANALISE")
		private AmostraEnum tipoAnalise;

		@Column(name = "VALOR")
		private BigDecimal valor;
		
		@Column(name = "OBSERVACAO", length = 800)
		private String observacao;*/
	
		return amostraDTO;		
	}
}

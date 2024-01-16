package com.fertilagro.fertilagroapp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fertilagro.fertilagroapp.conversor.LocalDateAttributeConverter;
import com.fertilagro.fertilagroapp.enumerador.MatrizEnum;
import com.fertilagro.fertilagroapp.pk.EmpresaPadraoIdPK;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AMOSTRA")
public class AmostraVO extends SuperVO implements Serializable {

	private static final long serialVersionUID = -5873661660191774642L;

	@EmbeddedId
	private EmpresaPadraoIdPK id;
	
	@Column(name = "PROPRIEDADE")
	private String propriedade;
	
	@ManyToOne
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
	
	@Column(name = "DESCRICAOAMOSTRA")
	private String descricaoAmostra;
	
	@Column(name = "MATRIZ")
	private MatrizEnum matriz;
	
	@Column(name = "TIPOANALISE")
	private String tipoAnalise;

	@Column(name = "VALOR")
	private BigDecimal valor;
	
	@Column(name = "OBSERVACAO", length = 800)
	private String observacao;
	
	public void setCliente(PessoaVO pessoa) {
		this.cliente = pessoa;
		if(pessoa != null) {
			setClienteId(pessoa.getId().getId());
		}
	}

	@Override
	public void setGerarIdentificadorId(Integer id) {
        if (this.id != null) {
            this.id.setId(id);
        }
	}

	@Override
	public Object getSuperId() {
		if (this.id != null) {
			return this.id.getId();
		}
		return null;
	}

	@Override
	public String getLabelFkfield() {
		return this.id != null ? this.id.getId().toString()+ " - Cliente: "+this.getCliente().getRazaoSocial() : null;
	}
}

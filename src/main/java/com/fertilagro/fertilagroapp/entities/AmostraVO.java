package com.fertilagro.fertilagroapp.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fertilagro.fertilagroapp.conversor.LocalDateAttributeConverter;
import com.fertilagro.fertilagroapp.enumerador.AmostraEnum;
import com.fertilagro.fertilagroapp.pk.EmpresaPadraoIdPK;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class AmostraVO extends SuperVO {

	@EmbeddedId
	private EmpresaPadraoIdPK id;
	
	@Column(name = "PROPRIEDADE")
	private String propriedade;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTE", referencedColumnName = "ID", insertable = false, updatable = false,
			foreignKey = @ForeignKey(name = "cliente"),nullable = true) 
	private PessoaVO cliente;*/
	
	@Column(name = "CLIENTE")
	private Integer clienteId;

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
	
    @Column(name = "NUMERO_PEDIDO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroPedido;

	@Column(name = "VALOR")
	private BigDecimal valor;
	
	@Column(name = "OBSERVACAO", length = 500)
	private String observacao;
	
	/*public void setCliente(PessoaVO pessoa) {
		this.cliente = pessoa;
		if(pessoa != null) {
			setClienteId(pessoa.getId());
		}
	}*/

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
		// TODO Auto-generated method stub
		return null;
	}
}

package com.fertilagro.fertilagroapp.entities;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fertilagro.fertilagroapp.anotacao.TabelaFilha;
import com.fertilagro.fertilagroapp.pk.EmpresaPedidoAmostraPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PEDIDOAMOSTRA")
@TabelaFilha(pai = PedidoVO.class)
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class PedidoAmostraVO extends SuperVO{

	@EmbeddedId
	private EmpresaPedidoAmostraPK id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "EMPRESA", referencedColumnName = "EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "PEDIDO", referencedColumnName = "ID", insertable = false, updatable = false)})
	private PedidoVO pedido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "EMPRESA", referencedColumnName = "EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "AMOSTRA", referencedColumnName = "ID", insertable = false, updatable = false)})
	private AmostraVO amostra;

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
		return this.id != null ? this.id.getId().toString() : null;
	}

}

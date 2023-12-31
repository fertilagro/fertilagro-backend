package com.fertilagro.fertilagroapp.entities;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PEDIDOAMOSTRA")
@TabelaFilha(pai = PedidoVO.class)
@AllArgsConstructor
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
	
	@Column(name="AMOSTRA")
	private Integer amostra;

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

package com.fertilagro.fertilagroapp.entities;

import com.fertilagro.fertilagroapp.anotacao.TabelaFilha;
import com.fertilagro.fertilagroapp.pk.EmpresaPedidoAmostraPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
public class PedidoAmostraVO extends SuperVO {

	@EmbeddedId
	private EmpresaPedidoAmostraPK id;

	@Override
	public void setGerarIdentificadorId(Integer id) {
        if (this.id != null) {
            this.id.setId(id);
        }
	}

	@Override
	public Object getSuperId() {
	/*	if (this.id != null) {
			return this.id.getId();
		}*/
		return null;
	}

	@Override
	public String getLabelFkfield() {
		// TODO Auto-generated method stub
		return null;
	}

}

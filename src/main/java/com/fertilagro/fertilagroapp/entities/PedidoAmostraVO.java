package com.fertilagro.fertilagroapp.entities;

import com.fertilagro.fertilagroapp.anotacao.TabelaFilha;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@Table(name = "PEDIDOAMOSTRA")
@TabelaFilha(pai = PedidoVO.class)
@AllArgsConstructor
@Getter
@Setter
public class PedidoAmostraVO extends SuperVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
   /* @Override
    protected void setGerarIdentificadorId(Integer id) {
        if (this.id != null) {
            this.id.setId(id);
        }
    }*/
    
	/*@Override
	public Integer getSuperId() {
		if (this.id != null) {
			return this.id.getId();
		}
		return null;
	}*/
}

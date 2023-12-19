package com.fertilagro.fertilagroapp.entities;

import java.time.LocalDate;
import java.util.List;

import com.fertilagro.fertilagroapp.pk.EmpresaPadraoIdPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "pedido")
public class PedidoVO extends SuperVO {

	@EmbeddedId
	private EmpresaPadraoIdPK id;
	
	@Column(name="DATA")
	private LocalDate data;

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
	
	
//	private List<PedidoAmostraVO> pedidoAmostras;
	
	
}

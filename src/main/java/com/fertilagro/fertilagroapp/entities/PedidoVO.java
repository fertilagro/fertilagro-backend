package com.fertilagro.fertilagroapp.entities;

import java.time.LocalDate;

import com.fertilagro.fertilagroapp.pk.EmpresaPadraoIdPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
@Table(name = "pedido")
public class PedidoVO extends SuperVO {

	@EmbeddedId
	private EmpresaPadraoIdPK id;
	
	@Column(name="DATA")
	private LocalDate data;

	@ManyToOne
	@JoinColumns(value = {
			@JoinColumn(name = "empresa", referencedColumnName = "empresa", insertable = false, updatable = false),
			@JoinColumn(name = "pessoa", referencedColumnName = "id", insertable = false, updatable = false)})
	private PessoaVO pessoa;
	@Column(name="PESSOA")
	private Integer pessoaId;
	
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

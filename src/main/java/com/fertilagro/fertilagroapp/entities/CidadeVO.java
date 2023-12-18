package com.fertilagro.fertilagroapp.entities;

import java.io.Serializable;

import com.fertilagro.fertilagroapp.enumerador.EstadoEnum;
import com.fertilagro.fertilagroapp.pk.CidadeEmpresaIdPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
@Table(name = "cidade")
public class CidadeVO extends SuperVO implements Serializable {

	private static final long serialVersionUID = -4236882528226531378L;

	@EmbeddedId
	private CidadeEmpresaIdPK id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "ESTADO")
	private EstadoEnum estado;	

	public String getLabelFkfield() {
		if(this.id != null)
			return this.getId() != null ? this.getId().getId()+" - "+this.getNome().toString(): null;
		return this.id.toString();
	}
	
    @Override
    protected void setGerarIdentificadorId(Integer id) {
        if (this.id != null) {
            this.id.setId(id);
        }
    }

/*	@Override
	public Integer getSuperId() {
		if (this.id != null) {
			return this.id.getId();
		}
		return null;
	}*/
}

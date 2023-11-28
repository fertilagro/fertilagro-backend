package com.fertilagro.fertilagroapp.entities;

import jakarta.persistence.Column;
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
@Table(name = "cidade")
public class CidadeVO extends SuperVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CODIGO_IBGE")
	private Integer codigoIbge;	
	
	//@Column(name = "ESTADO")
	//private EstadoEnum estado;
	

	public String getLabelFkfield() {
		if(this.id != null)
			return this.getId() != null ? this.getId()+" - "+this.getNome().toString(): null;
		return this.id.toString();
	}
}

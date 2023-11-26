package com.fertilagro.fertilagroapp.entities;

import com.fertilagro.fertilagroapp.enumerador.EstadoEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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
	
	@Column(name = "ESTADO")
	private EstadoEnum estado;
	
	private String labelFkField;
	
	public void setLabelFkField() {
		this.labelFkField = id.toString() +" - "+ nome;
	}
}

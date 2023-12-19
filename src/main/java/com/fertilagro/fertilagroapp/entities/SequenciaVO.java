package com.fertilagro.fertilagroapp.entities;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fertilagro.fertilagroapp.pk.SequenciaPK;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sequencia")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@IdClass(SequenciaPK.class)
public class SequenciaVO extends SuperVO {

	@Id
	private Integer empresa;
	@Id
	private String tabela;	
	
	@Column(name="SEQUENCIA")
	private Integer id;
	
	@Override
	public void setGerarIdentificadorId(Integer id) {
		this.id = id;
	}
	@Override
	public Object getSuperId() {
		return null;
	}
}

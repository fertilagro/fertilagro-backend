package com.fertilagro.fertilagroapp.entities;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fertilagro.fertilagroapp.pk.SequenciaPK;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "sequencia")
@DynamicInsert
@DynamicUpdate
@IdClass(SequenciaPK.class)
public class SequeciaVO {


	@Id
	private Integer empresa;
	@Id
	private String tabela;
	@Column(name="SEQUENCIA")
	private Integer id;
}

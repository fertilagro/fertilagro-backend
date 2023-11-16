package com.fertilagro.fertilagroapp.entities;

import org.hibernate.annotations.DynamicInsert;

import com.fertilagro.fertilagroapp.enumerador.StatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
@Table(name = "pessoa")
@DynamicInsert
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PessoaVO {
	
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public void setRazaoSocial(String razaoSocial) {
//		this.razaoSocial = razaoSocial;
//	}
//
//	public void setStatus(StatusEnum status) {
//		this.status = status;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Column(name = "RAZAOSOCIAL")
	private String razaoSocial;
	
    @Column(name = "STATUS")
	private StatusEnum status;

	
}

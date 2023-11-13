package com.fertilagro.fertilagroapp.dto;


import com.fertilagro.fertilagroapp.entities.Endereco;
import com.fertilagro.fertilagroapp.enumerador.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PessoaDTO {
	
	private Integer id;
	private String razaoSocial;
	private StatusEnum status;	
	private Endereco endereco;

}

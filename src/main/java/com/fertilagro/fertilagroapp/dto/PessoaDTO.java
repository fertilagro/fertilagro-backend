package com.fertilagro.fertilagroapp.dto;


import com.fertilagro.fertilagroapp.entities.PessoaVO;
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
public class PessoaDTO extends SuperDTO<PessoaVO> {
	
	private Integer id;
	private String razaoSocial;
    private String cnpjCpf;
    private String telefone;
    private String email;
    private String endereco;
    private String cidade;
    private String estado;
	private StatusEnum status;

}

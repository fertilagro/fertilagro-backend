package com.fertilagro.fertilagroapp.dto;


import com.fertilagro.fertilagroapp.entities.PessoaVO;
import com.fertilagro.fertilagroapp.enumerador.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO extends SuperDTO<PessoaVO> {
	
	private Integer id;
	private String razaoSocial;
    private String cnpjCpf;
    private String telefone;
    private String email;
    private String endereco;
    private CidadeDTO cidade;
	private StatusEnum status;

}

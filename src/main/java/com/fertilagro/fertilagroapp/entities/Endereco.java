package com.fertilagro.fertilagroapp.entities;

import com.fertilagro.fertilagroapp.enumerador.EstadoEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Embeddable
public class Endereco {
	
	@Column(name = "CEP")
    private String cep;
	
	@Column(name = "LOGRADOURO")
    private String logradouro;

	@Column(name = "NUMERO")
    private String numero;

	@Column(name = "COMPLEMENTO")
    private String complemento;

	@Column(name = "BAIRRO")
    private String bairro;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private CidadeVO cidade;

	@Column(name = "ESTADO")
	private EstadoEnum estado;
    
}

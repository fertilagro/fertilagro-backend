package com.fertilagro.fertilagroapp.pk;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Embeddable
@Data
@AllArgsConstructor
public class CidadeEmpresaIdPK implements Serializable {

	private static final long serialVersionUID = 4171333912350755212L;

	@Column(name = "EMPRESA", columnDefinition = "MEDIUMINT", length = 6)
    private Integer empresa;

    @Column(name = "ID", columnDefinition = "SMALLINT", length = 6)
    private Integer id;
	
    // Construtor sem argumentos é necessário para o JPA
    public CidadeEmpresaIdPK() {
   
    }
    
}

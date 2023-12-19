package com.fertilagro.fertilagroapp.pk;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmpresaPadraoIdPK implements Serializable {

	private static final long serialVersionUID = 4171333912350755212L;

	@Column(name = "EMPRESA")
    private Integer empresa;

    @Column(name = "ID")
    private Integer id;
    
}

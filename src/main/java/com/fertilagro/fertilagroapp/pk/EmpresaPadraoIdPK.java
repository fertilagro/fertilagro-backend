package com.fertilagro.fertilagroapp.pk;

import java.io.Serializable;

import com.fertilagro.fertilagroapp.dto.pk.EmpresaPadraoIdPKDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class EmpresaPadraoIdPK implements Serializable {

	private static final long serialVersionUID = 4171333912350755212L;

	@Column(name = "EMPRESA")
    private Integer empresa;

    @Column(name = "ID")
    private Integer id;
    
    public EmpresaPadraoIdPK() {
    }
    
    public EmpresaPadraoIdPK(Integer empresa, Integer id) {
    	this.empresa = empresa;
    	this.id = id;
    }
    
    public EmpresaPadraoIdPK(EmpresaPadraoIdPKDTO empresaPadraoIdPKDTO) {
    	this.empresa = empresaPadraoIdPKDTO.getEmpresa();
    	this.id = empresaPadraoIdPKDTO.getId();
    }
    
}

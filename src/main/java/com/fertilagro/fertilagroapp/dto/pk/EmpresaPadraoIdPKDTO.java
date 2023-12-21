package com.fertilagro.fertilagroapp.dto.pk;

import java.io.Serializable;

import com.fertilagro.fertilagroapp.pk.EmpresaPadraoIdPK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaPadraoIdPKDTO implements Serializable {

    private Integer empresa;
    private Integer id;
    
    public EmpresaPadraoIdPKDTO(EmpresaPadraoIdPK empresaPadraoIdPK) {
    	this.empresa = empresaPadraoIdPK.getEmpresa();
    	this.id = empresaPadraoIdPK.getId();
    }
    
}

package com.fertilagro.fertilagroapp.repositorio;

import org.springframework.stereotype.Repository;

import com.fertilagro.fertilagroapp.entities.SequenciaVO;
import com.fertilagro.fertilagroapp.pk.SequenciaPK;

@Repository
public class SequenciaRepositorio extends SuperRepositorio<SequenciaVO> {

    public Integer buscaMaxDinamico(SequenciaPK sequenciaPK) {
        Integer id = 0;
        StringBuilder condicao = new StringBuilder();

        if (sequenciaPK.getEmpresa() != null && sequenciaPK.getEmpresa() > 0) {
            condicao.append(" EMPRESA = " + sequenciaPK.getEmpresa());
        }
        // faz o max na tabela pra pegar o ultimo ID
        Object singleResult = getSession().createNativeQuery("SELECT MAX(ID) FROM " + sequenciaPK.getTabela() + ("".equals(condicao.toString()) ? "" : " A WHERE " 
        + condicao.toString())).getSingleResult();
        if (singleResult != null) {
            Integer max = 0;
            if (singleResult instanceof Integer) {
                max = (Integer) singleResult;
            } else {
                max = ((Short) singleResult).intValue();
            }
            if (max > 0) {
                id = max;
            }
        }
        return id;
    }
    
}

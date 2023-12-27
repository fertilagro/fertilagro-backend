package com.fertilagro.fertilagroapp.repositorio;

import org.springframework.stereotype.Repository;

import com.fertilagro.fertilagroapp.entities.SequenciaVO;
import com.fertilagro.fertilagroapp.pk.SequenciaPK;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

@Repository
public class SequenciaRepositorio extends SuperRepositorio<SequenciaVO> {

    public Integer buscaMaxDinamico2(SequenciaPK sequenciaPK) {
        Integer id = 0;
        StringBuilder condicao = new StringBuilder();

        if (sequenciaPK.getEmpresa() != null && sequenciaPK.getEmpresa() > 0) {
            condicao.append(" EMPRESA = " + sequenciaPK.getEmpresa());
        }
        
        if (sequenciaPK.getTabela() != null) {
            condicao.append(" AND TABELA = " + sequenciaPK.getTabela());
        }
        // faz o max na tabela pra pegar o ultimo ID
        Object singleResult = getSession().createNativeQuery("SELECT MAX(SEQUENCIA) FROM SEQUENCIA WHERE " 
        + condicao.toString()).getSingleResult();
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
    
    public Integer buscaMaxDinamico(SequenciaPK sequenciaPK) {
        Integer id = 0;
    	StringBuilder sb = new StringBuilder();
		
		sb.append(" SELECT MAX(SEQUENCIA) ");
		sb.append(" FROM SEQUENCIA ");
		sb.append(" WHERE ");
		sb.append("     EMPRESA = :empresa ");
		sb.append(" AND TABELA = :tabela ");
		
		Query createQuery = getSession().createNativeQuery(sb.toString());
		createQuery.setParameter("empresa", sequenciaPK.getEmpresa());
		createQuery.setParameter("tabela", sequenciaPK.getTabela());
		
		try {	
			Object singleResult = createQuery.setMaxResults(1).getSingleResult();
			
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
		}catch (NoResultException nre){
			return null;
		} 
    }
    
    
    
}

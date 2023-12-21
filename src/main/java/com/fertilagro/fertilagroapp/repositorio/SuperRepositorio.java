package com.fertilagro.fertilagroapp.repositorio;

import com.fertilagro.fertilagroapp.arquitetura.BaseRepositorio;
import com.fertilagro.fertilagroapp.entities.SuperVO;

public abstract class SuperRepositorio<T extends SuperVO> extends BaseRepositorio {
	
	/*public String getValorParametro(Integer empresa, Integer filial, String idParametro) {		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT p ");
		sb.append(" FROM ").append(CidadeVO.class.getSimpleName()).append(" p ");
		sb.append(" WHERE ");
		sb.append("  p.id.empresa = :campo1 ");
		sb.append("  AND p.parametro.id = :campo2 ");
		sb.append("  AND p.filial.id.id = :campo3 ");
		sb.append("  AND p.status = :campo4 ");
		sb.append("  order by p.id.empresa DESC, p.id.id DESC ");
		
		Query createQuery = getSession().createQuery(sb.toString());
		createQuery.setParameter("campo1", empresa);
		createQuery.setParameter("campo2", idParametro);
		createQuery.setParameter("campo3", filial);
		//createQuery.setParameter("campo4", StatusEnum.ATIVO);
		createQuery.setMaxResults(1);
		 
		try {
			
			return (String) createQuery.getSingleResult(); 
		}catch (NoResultException nre){
			return "";
		}
	}*/
	
}

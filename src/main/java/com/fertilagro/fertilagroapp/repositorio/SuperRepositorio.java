package com.fertilagro.fertilagroapp.repositorio;

import java.util.List;

import com.fertilagro.fertilagroapp.arquitetura.BaseRepositorio;
import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.entities.SuperVO;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public abstract class SuperRepositorio<T extends SuperVO> extends BaseRepositorio {
	
	public T insere(T entity) {
		getSession().persist(entity);
		return entity;
	}
	
	public T altera(T entity) {
		return getSession().merge(entity);
	}
	
	public void deleta(T entity) {
		getSession().remove(entity);
	}

	public void atualiza(T entity) {
		getSession().refresh(entity);
	}

	public void flush() {
		getSession().flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> encontrarPorAtributoPersonalizado(String nome) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(" SELECT s ");
		sb.append(" FROM ").append(CidadeVO.class.getSimpleName()).append(" s ");
		sb.append(" WHERE ");
		sb.append("     s.id.empresa = :empresa ");
		sb.append(" AND s.nome like '%").append(nome).append("%' ");
		
		
		Query createQuery = getSession().createQuery(sb.toString());
		createQuery.setParameter("empresa", 1);
		 
		try {	
			return (List<T>) createQuery.getResultList(); 
		}catch (NoResultException nre){
			return null;
		} 
	}	
	
}

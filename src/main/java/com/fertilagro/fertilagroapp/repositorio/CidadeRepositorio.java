package com.fertilagro.fertilagroapp.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fertilagro.fertilagroapp.entities.CidadeVO;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

@Repository
public class CidadeRepositorio extends SuperRepositorio<CidadeVO> {
	
	@SuppressWarnings("unchecked")
	public List<CidadeVO> encontrarPorAtributoPersonalizado(String nome) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(" SELECT s ");
		sb.append(" FROM ").append(CidadeVO.class.getSimpleName()).append(" s ");
		sb.append(" WHERE ");
		sb.append("     s.id.empresa = :empresa ");
		sb.append(" AND s.nome like '%").append(nome).append("%' ");
		
		
		Query createQuery = getSession().createQuery(sb.toString());
		createQuery.setParameter("empresa", 1);
		 
		try {	
			return (List<CidadeVO>) createQuery.getResultList(); 
		}catch (NoResultException nre){
			return null;
		} 
	}
	
	public CidadeVO encontrarPorId(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT s ");
		sb.append(" FROM ").append(CidadeVO.class.getSimpleName()).append(" s ");
		sb.append(" WHERE ");
		sb.append("      s.id.empresa = :empresa ");
		sb.append(" AND s.id.id = :id ");
			
		Query createQuery = getSession().createQuery(sb.toString());
		createQuery.setParameter("empresa", 1);
		createQuery.setParameter("id", id);
		 
		try {	
			return (CidadeVO) createQuery.getSingleResult(); 
		}catch (NoResultException nre){
			return null;
		} 
	}

	
}

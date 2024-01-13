package com.fertilagro.fertilagroapp.repositorio;

import java.util.List;

import com.fertilagro.fertilagroapp.arquitetura.BaseRepositorio;
import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.entities.PedidoVO;
import com.fertilagro.fertilagroapp.entities.PessoaVO;
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
	public List<T> buscaCidadePorNome(String nome) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT s ");
		sb.append(" FROM ").append(CidadeVO.class.getSimpleName()).append(" s ");
		sb.append(" WHERE ");
		sb.append("     s.id.empresa = :empresa ");
		sb.append(" AND s.nome like UPPER('%").append(nome).append("%') ");
		
		Query createQuery = getSession().createQuery(sb.toString());
		createQuery.setParameter("empresa", 1);
		 
		try {	
			return (List<T>) createQuery.getResultList(); 
		}catch (NoResultException nre){
			return null;
		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscaPessoaPorNome(String nome) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT s ");
		sb.append(" FROM ").append(PessoaVO.class.getSimpleName()).append(" s ");
		sb.append(" WHERE ");
		sb.append("     s.id.empresa = :empresa ");
		sb.append(" AND s.razaoSocial like UPPER('%").append(nome).append("%') ");
		
		Query createQuery = getSession().createQuery(sb.toString());
		createQuery.setParameter("empresa", 1);
		 
		try {	
			return (List<T>) createQuery.getResultList(); 
		}catch (NoResultException nre){
			return null;
		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscarPorChaveCidade(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT s ");
		sb.append(" FROM ").append(CidadeVO.class.getSimpleName()).append(" s ");
		sb.append(" WHERE ");
		sb.append("     s.id.empresa = :empresa ");
		sb.append(" AND s.id.id = :id ");
		
		Query createQuery = getSession().createQuery(sb.toString());
		createQuery.setParameter("empresa", 1);
		createQuery.setParameter("id", id);
		 
		try {	
			return (List<T>) createQuery.getResultList(); 
		}catch (NoResultException nre){
			return null;
		} 
	}	
	
	@SuppressWarnings("unchecked")
	public List<T> buscarPorChavePessoa(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT s ");
		sb.append(" FROM ").append(PessoaVO.class.getSimpleName()).append(" s ");
		sb.append(" WHERE ");
		sb.append("     s.id.empresa = :empresa ");
		sb.append(" AND s.id.id = :id ");
		
		Query createQuery = getSession().createQuery(sb.toString());
		createQuery.setParameter("empresa", 1);
		createQuery.setParameter("id", id);
		 
		try {	
			return (List<T>) createQuery.getResultList(); 
		}catch (NoResultException nre){
			return null;
		} 
	}	
	
	public T buscarPorId(Integer empresa, Integer id, String tipo) {
		StringBuilder sb = new StringBuilder();
		T retorno = null;
		sb.append(" SELECT s ");
		if (tipo.equals("pedidos")) {			
			sb.append(" FROM ").append(PedidoVO.class.getSimpleName()).append(" s ");
		} else if (tipo.equals("cidades")) {
			sb.append(" FROM ").append(CidadeVO.class.getSimpleName()).append(" s ");
		} else {
			
		}
		sb.append(" WHERE ");
		sb.append("     s.id.empresa = :empresa ");
		sb.append(" AND s.id.id = :id ");
		
		Query createQuery = getSession().createQuery(sb.toString());
		createQuery.setParameter("empresa", empresa);
		createQuery.setParameter("id", id);
		 
		try {	
			retorno = (T) createQuery.getSingleResult();
		}catch (NoResultException nre){
			retorno = null;
		} 
		
		return retorno;
	}	
	
}

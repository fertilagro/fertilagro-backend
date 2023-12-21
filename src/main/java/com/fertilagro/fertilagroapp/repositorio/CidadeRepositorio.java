package com.fertilagro.fertilagroapp.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fertilagro.fertilagroapp.entities.CidadeVO;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class CidadeRepositorio extends SuperRepositorio<CidadeVO> {
	
	public Page<CidadeVO> encontrarPorAtributoPersonalizado(String nome) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(" SELECT s ");
		sb.append(" FROM ").append(CidadeVO.class.getSimpleName()).append(" s ");
		sb.append(" WHERE ");
		sb.append("      s.id.empresa = :empresa ");
	//	sb.append("  AND s.nome = :nome ");
		sb.append(" AND s.nome like '%").append(nome).append("%' ");
		
		
		Query createQuery = getSession().createQuery(sb.toString());
		createQuery.setParameter("empresa", 1);
		 
		try {	
			return (Page<CidadeVO>) createQuery.getSingleResult(); 
		}catch (NoResultException nre){
			return null;
		} 
	}
	
//    @Query("SELECT s FROM CidadeVO s WHERE LOWER(s.nome) LIKE LOWER(CONCAT('%', :valor ,'%'))")
//    Page<CidadeVO> encontrarPorAtributoPersonalizado(@Param("valor") String valor, Pageable pageable);
//    
//    @Query("SELECT s FROM CidadeVO s WHERE s.id = :valor")
//    Page<CidadeVO> encontrarPorId(@Param("valor") Integer valor, Pageable pageable);
	
}

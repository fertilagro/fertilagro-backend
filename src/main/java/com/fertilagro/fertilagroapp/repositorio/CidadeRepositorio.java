package com.fertilagro.fertilagroapp.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fertilagro.fertilagroapp.entities.CidadeVO;

public interface CidadeRepositorio extends JpaRepository<CidadeVO, Integer> { 
	
    @Query("SELECT s FROM CidadeVO s WHERE LOWER(s.nome) LIKE LOWER(CONCAT('%', :valor ,'%'))")
    Page<CidadeVO> encontrarPorAtributoPersonalizado(@Param("valor") String valor, Pageable pageable);
    
    @Query("SELECT s FROM CidadeVO s WHERE s.id = :valor")
    Page<CidadeVO> encontrarPorId(@Param("valor") Integer valor, Pageable pageable);
	
}

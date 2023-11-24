package com.fertilagro.fertilagroapp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fertilagro.fertilagroapp.entities.CidadeVO;

public interface CidadeRepositorio extends JpaRepository<CidadeVO, Integer> { 
	
    @Query("SELECT s FROM CidadeVO s WHERE s.nome = :valor")
    CidadeVO encontrarPorAtributoPersonalizado(@Param("valor") String valor);
	
}

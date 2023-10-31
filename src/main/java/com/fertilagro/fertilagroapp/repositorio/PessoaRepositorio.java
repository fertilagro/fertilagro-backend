package com.fertilagro.fertilagroapp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fertilagro.fertilagroapp.entities.PessoaVO;

public interface PessoaRepositorio extends JpaRepository<PessoaVO, Integer>{
	
}

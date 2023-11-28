package com.fertilagro.fertilagroapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fertilagro.fertilagroapp.dto.CidadeDTO;
import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.repositorio.CidadeRepositorio;
import com.fertilagro.fertilagroapp.util.uteis;

@Service
public class CidadeService extends SuperService<CidadeVO, Integer>{

	@Autowired
	private CidadeRepositorio cidadeRepositorio;
	
    public Page<CidadeVO> buscarPorFkField(String dados, Pageable pageable) {
    	Page<CidadeVO> lista;
    	if (uteis.ContemSomenteNumero(dados)) {
    		 Integer id = Integer.parseInt(dados);
    		 lista = cidadeRepositorio.encontrarPorId(id, pageable);
    	} else {
    		 lista = cidadeRepositorio.encontrarPorAtributoPersonalizado(dados, pageable);
    	}
    	return lista;
    }
    
    public List<CidadeDTO> list() {
    	return null;
    }
}

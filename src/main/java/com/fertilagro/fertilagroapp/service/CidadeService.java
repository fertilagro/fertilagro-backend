package com.fertilagro.fertilagroapp.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.repositorio.CidadeRepositorio;
import com.fertilagro.fertilagroapp.repositorio.SuperRepositorio;
import com.fertilagro.fertilagroapp.util.uteis;

@Service
public class CidadeService extends SuperService<CidadeVO> implements Serializable {

	private static final long serialVersionUID = -6863324122165548817L;
	
	@Autowired
	private CidadeRepositorio cidadeRepositorio;
	
	@Override
	protected SuperRepositorio<CidadeVO> getRepositorio() {
		return cidadeRepositorio;
	}
	
    public Page<CidadeVO> buscarPorFkField(String dados, Pageable pageable) {
    	Page<CidadeVO> lista = null;
    	if (uteis.ContemSomenteNumero(dados)) {
    		 Integer id = Integer.parseInt(dados);
    		// lista = cidadeRepositorio.encontrarPorId(id);
    	} else {
    		 lista = cidadeRepositorio.encontrarPorAtributoPersonalizado(dados);
    	}
    	return lista;
    }
  
}

package com.fertilagro.fertilagroapp.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fertilagro.fertilagroapp.entities.SequenciaVO;
import com.fertilagro.fertilagroapp.pk.SequenciaPK;
import com.fertilagro.fertilagroapp.repositorio.SequenciaRepositorio;
import com.fertilagro.fertilagroapp.repositorio.SuperRepositorio;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor=Exception.class)
public class SequenciaService extends SuperService<SequenciaVO> implements Serializable {

	private static final long serialVersionUID = -1001796244364235853L;
	
	@Autowired
	private SequenciaRepositorio sequenciaRepositorio;
	
	@Override
	protected SuperRepositorio<SequenciaVO> getRepositorio() {
		return sequenciaRepositorio;
	}
	
	@Override
	protected SequenciaService getSequenciaService() {
		return null;
	}

	public SequenciaVO gerarChave(SequenciaPK sequenciaPK) {		
		SequenciaVO sequenciaVO = new SequenciaVO();
        Integer id = sequenciaRepositorio.buscaMaxDinamico(sequenciaPK);
        
        if (id == 0) {     	
        	sequenciaVO.setEmpresa(sequenciaPK.getEmpresa());
        	sequenciaVO.setTabela(sequenciaPK.getTabela());
        	sequenciaVO.setId(1);       	
        	sequenciaVO = getRepositorio().insere(sequenciaVO);
        } else {
        	sequenciaVO.setEmpresa(sequenciaPK.getEmpresa());
        	sequenciaVO.setTabela(sequenciaPK.getTabela());
        	sequenciaVO.setId(id +1);       	
        	sequenciaVO = getRepositorio().altera(sequenciaVO);
        } 
		return sequenciaVO;
	}

}

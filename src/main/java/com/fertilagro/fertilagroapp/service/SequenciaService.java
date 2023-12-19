package com.fertilagro.fertilagroapp.service;

import org.springframework.stereotype.Service;

import com.fertilagro.fertilagroapp.entities.SequenciaVO;
import com.fertilagro.fertilagroapp.pk.SequenciaPK;

@Service
public class SequenciaService extends SuperService<SequenciaVO, Integer> {

	public SequenciaVO gerarChave(SequenciaPK sequencia) {
		return null;
	}
}

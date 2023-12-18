package com.fertilagro.fertilagroapp.arquitetura;

import com.fertilagro.fertilagroapp.anotacao.TabelaFilha;
import com.fertilagro.fertilagroapp.entities.SuperVO;

public class EntityUteis {

	public static boolean isTabelaFilha(Class<? extends SuperVO> class1) {
		TabelaFilha tabelaFilha = (TabelaFilha) class1.getAnnotation(TabelaFilha.class);
		return tabelaFilha != null;
	}
	
	public static Object setIdCrud(Object crud, Integer empresa, Object id) {
		return null;
	}
	
}

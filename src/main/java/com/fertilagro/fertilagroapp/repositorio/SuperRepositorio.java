package com.fertilagro.fertilagroapp.repositorio;

import com.fertilagro.fertilagroapp.arquitetura.BaseRepositorio;
import com.fertilagro.fertilagroapp.entities.SuperVO;

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
	
}

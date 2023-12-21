package com.fertilagro.fertilagroapp.arquitetura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class BaseRepositorio {

	@PersistenceContext EntityManager em;
	
	public EntityManager getSession( ) {
		return em;
	}
}

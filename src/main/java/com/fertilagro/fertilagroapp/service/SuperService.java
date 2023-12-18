package com.fertilagro.fertilagroapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fertilagro.fertilagroapp.arquitetura.EntityUteis;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class SuperService<T, ID> {

    @Autowired
    private JpaRepository<T, ID> repository;

    public List<T> listarTodos() {
        return repository.findAll();
    }

    public Optional<T> buscarPorId(ID id) {
        return repository.findById(id);
    }

    public T insere(T entity) {
    	
    	
      //  EntityUteis.setIdCrud(entity, 1, entity.getSuperId());
    	
    	
    	
    	entity = validaRegrasAntesSalvar(entity);
    	entity = repository.save(entity);
        return entity;
    }

    public T alterar(T entity) {
        return repository.save(entity);
    }

    public void excluir(ID id) {
        repository.deleteById(id);
    } 
    
    public T validaRegrasAntesSalvar(T entity) {
    	return entity;
    }
}

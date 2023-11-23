package com.fertilagro.fertilagroapp.controllers;

import java.util.List;
import java.util.Optional;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fertilagro.fertilagroapp.dto.superDTO;
import com.fertilagro.fertilagroapp.service.SuperService;

import jakarta.persistence.MappedSuperclass;

@CrossOrigin
@MappedSuperclass
public class SuperController<T, ID> {

    private final SuperService<T, ID> service;

    @Autowired
    public SuperController(SuperService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    public List<T> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> buscarPorId(@PathVariable ID id) {
        Optional<T> entity = service.buscarPorId(id);
        return entity.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/salvar")
    public ResponseEntity<T> incluir(@RequestBody T entity) {
        T novaEntidade = service.insere(entity);
        return new ResponseEntity<>(novaEntidade, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> alterar(@PathVariable ID id, @RequestBody T entity) {
        if (service.buscarPorId(id).isPresent()) {
            T entidadeAlterada = service.alterar(entity);
            return new ResponseEntity<>(entidadeAlterada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable ID id) {
        if (service.buscarPorId(id).isPresent()) {
            service.excluir(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/buscarPorFkField")
    public ResponseEntity<superDTO<T>> buscarPorFkField(@RequestBody T entity) {
    	return new ResponseEntity<>(HttpStatus.OK);
    }
}

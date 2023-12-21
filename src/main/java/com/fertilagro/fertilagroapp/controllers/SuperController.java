package com.fertilagro.fertilagroapp.controllers;

import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fertilagro.fertilagroapp.arquitetura.EntityUteis;
import com.fertilagro.fertilagroapp.dto.SuperDTO;
import com.fertilagro.fertilagroapp.entities.SuperVO;
import com.fertilagro.fertilagroapp.service.SuperService;

@CrossOrigin(origins = "*", maxAge = 3600)
public abstract class SuperController<T extends SuperVO, C extends SuperDTO<T>> {

    protected abstract SuperService<T> getSuperControler();
    
    protected Class<T> voClass;
    protected Class<C> dtoClass;

    @GetMapping
    public List<T> listarTodos() {
        return getSuperControler().listarTodos();
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<T> buscarPorId(@PathVariable ID id) {
        Optional<T> entity = service.buscarPorId(id);
        return entity.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }*/

    @PostMapping("/salvar")
    public ResponseEntity<T> incluir(@RequestBody T entity)  {
        T novaEntidade = null;
        try {
            EntityUteis.setIdCrud(entity, 1, entity.getSuperId());
            novaEntidade = getSuperControler().insere(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

        return new ResponseEntity<>(novaEntidade, HttpStatus.CREATED);
    }

   /* @PutMapping("/{id}")
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
    }*/
    

    
}

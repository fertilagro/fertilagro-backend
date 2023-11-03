package com.fertilagro.fertilagroapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilagro.fertilagroapp.entities.PessoaVO;
import com.fertilagro.fertilagroapp.service.PessoaService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaVO> findAll() {
        return pessoaService.findAll();
    }

    @GetMapping("/{id}")
    public PessoaVO findById(@PathVariable Integer id) {
        return pessoaService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
    }

    @PostMapping
    public PessoaVO save(@RequestBody PessoaVO pessoa) {
        return pessoaService.save(pessoa);
    }

    @PutMapping("/{id}")
    public PessoaVO update(@PathVariable Integer id, @RequestBody PessoaVO pessoa) {
        pessoa.setId(id);
        return pessoaService.update(pessoa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        pessoaService.delete(id);
    }
}

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

import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.service.CidadeService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    @GetMapping
    public List<CidadeVO> findAll() {
        return cidadeService.findAll();
    }

    @GetMapping("/{id}")
    public CidadeVO findById(@PathVariable Integer id) {
        return cidadeService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada"));
    }

    @PostMapping
    public CidadeVO save(@RequestBody CidadeVO cidade) {
        return cidadeService.save(cidade);
    }

    @PutMapping("/{id}")
    public CidadeVO update(@PathVariable Integer id, @RequestBody CidadeVO cidade) {
        cidade.setId(id);
        return cidadeService.update(cidade);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cidadeService.delete(id);
    }
}


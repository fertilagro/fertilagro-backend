package com.fertilagro.fertilagroapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fertilagro.fertilagroapp.entities.PessoaVO;
import com.fertilagro.fertilagroapp.repositorio.PessoaRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    public List<PessoaVO> findAll() {
        return pessoaRepositorio.findAll();
    }

    public Optional<PessoaVO> findById(Integer id) {
        return pessoaRepositorio.findById(id);
    }

    public PessoaVO save(PessoaVO pessoa) {
        return pessoaRepositorio.save(pessoa);
    }

    public PessoaVO update(PessoaVO pessoa) {

        if (pessoaRepositorio.existsById(pessoa.getId())) {
            return pessoaRepositorio.save(pessoa);
        } else {

            throw new EntityNotFoundException("Pessoa não encontrada");
        }
    }

    public void delete(Integer id) {
        pessoaRepositorio.deleteById(id);
    }
}

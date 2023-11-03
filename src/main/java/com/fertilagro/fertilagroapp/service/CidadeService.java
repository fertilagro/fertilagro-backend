package com.fertilagro.fertilagroapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fertilagro.fertilagroapp.entities.CidadeVO;
import com.fertilagro.fertilagroapp.repositorio.CidadeRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CidadeService {

    @Autowired
    CidadeRepositorio cidadeRepositorio;

    public List<CidadeVO> findAll() {
        return cidadeRepositorio.findAll();
    }

    public Optional<CidadeVO> findById(Integer id) {
        return cidadeRepositorio.findById(id);
    }

    public CidadeVO save(CidadeVO cidade) {
        return cidadeRepositorio.save(cidade);
    }

    public CidadeVO update(CidadeVO cidade) {
        if (cidadeRepositorio.existsById(cidade.getId())) {
            return cidadeRepositorio.save(cidade);
        } else {
            throw new EntityNotFoundException("Cidade não encontrada");
        }
    }

    public void delete(Integer id) {
        cidadeRepositorio.deleteById(id);
    }
}

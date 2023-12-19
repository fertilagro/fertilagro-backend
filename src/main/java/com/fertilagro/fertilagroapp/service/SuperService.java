package com.fertilagro.fertilagroapp.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fertilagro.fertilagroapp.arquitetura.EntityUteis;
import com.fertilagro.fertilagroapp.entities.SequenciaVO;
import com.fertilagro.fertilagroapp.entities.SuperVO;
import com.fertilagro.fertilagroapp.pk.EmpresaPadraoIdPK;
import com.fertilagro.fertilagroapp.pk.SequenciaPK;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class SuperService<T extends SuperVO, ID> {

    @Autowired
    private JpaRepository<T, ID> repository;
    @Autowired
    private SequenciaService sequenciaService;

    public List<T> listarTodos() {
        return repository.findAll();
    }

    public Optional<T> buscarPorId(ID id) {
        return repository.findById(id);
    }

    public T insere(T entity) {
    	entity = geraSequencia(entity);
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
    
    public T geraSequencia(T entity)  {
    	SequenciaPK sequenciaPK = new SequenciaPK();
    	Integer empresa = getIdEmpresa(entity); 
    	sequenciaPK.setEmpresa(empresa);
    	String tabela = EntityUteis.getNomeTabelaEntidade(entity.getClass());
    	sequenciaPK.setTabela(tabela);
    	SequenciaVO sequenciaVO = sequenciaService.gerarChave(sequenciaPK);
    	
		entity.setGerarIdentificadorId(sequenciaVO.getId());
		
    	return entity;
    }
    
    private Integer getIdEmpresa(T entity) {
		if (entity != null) {
			try {
				// Obtém os campos ID
				Field idField = null;
				idField = entity.getClass().getDeclaredField("id");
				// Define o campo como acessível
				idField.setAccessible(true);
				
				EmpresaPadraoIdPK id = null;
				// Obtém o valor do campo
				id = (EmpresaPadraoIdPK) idField.get(entity);
				return id.getEmpresa();
				
			} catch (Exception e) {e.printStackTrace();}
		}
		return null;
    }
}

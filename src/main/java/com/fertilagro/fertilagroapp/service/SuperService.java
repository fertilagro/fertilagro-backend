package com.fertilagro.fertilagroapp.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import com.fertilagro.fertilagroapp.arquitetura.EntityUteis;
import com.fertilagro.fertilagroapp.entities.SequenciaVO;
import com.fertilagro.fertilagroapp.entities.SuperVO;
import com.fertilagro.fertilagroapp.pk.EmpresaPadraoIdPK;
import com.fertilagro.fertilagroapp.pk.SequenciaPK;
import com.fertilagro.fertilagroapp.repositorio.SuperRepositorio;

public abstract class SuperService<T extends SuperVO> {
	
	//public JpaRepository<T, ID> repository;
	
//	@Autowired
//	private SuperRepositorio getDAO;
	
	protected abstract SuperRepositorio<T> getRepositorio();
	
    public List<T> listarTodos() {
        //return .findAll();
        return null;
    }

    public Optional<T> buscarPorId() {
     //   return repository.findById(id);
        return null;
    }

    public T insere(T entity) {
    	entity = geraSequencia(entity);
    	//entity = repository.save(entity);
        return entity;
    }

    public T alterar(T entity) {
     //   return repository.save(entity);
        return null;
    }

    public void excluir() {
      // repository.deleteById(id);
    } 
    
    public T geraSequencia(T entity)  {
    	SequenciaPK sequenciaPK = new SequenciaPK();
    	Integer empresa = getIdEmpresa(entity); 
    	sequenciaPK.setEmpresa(empresa);
    	String tabela = EntityUteis.getNomeTabelaEntidade(entity.getClass());
    	sequenciaPK.setTabela(tabela);
    	SequenciaVO sequenciaVO = gerarChave(sequenciaPK);
    	
		entity.setGerarIdentificadorId(sequenciaVO.getId());
		
    	return entity;
    }
    
    private SequenciaVO gerarChave(SequenciaPK sequenciaPK) {
    	
    	
    	
    	
    	return null;
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

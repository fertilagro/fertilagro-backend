package com.fertilagro.fertilagroapp.arquitetura;

import java.lang.reflect.Field;

import com.fertilagro.fertilagroapp.anotacao.TabelaFilha;
import com.fertilagro.fertilagroapp.entities.SuperVO;
import com.fertilagro.fertilagroapp.pk.EmpresaPadraoIdPK;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

public class EntityUteis {

	public static boolean isTabelaFilha(Class<? extends SuperVO> class1) {
		TabelaFilha tabelaFilha = (TabelaFilha) class1.getAnnotation(TabelaFilha.class);
		return tabelaFilha != null;
	}
	
	public static Object setIdCrud(Object crud, Integer empresa, Object id) throws IllegalArgumentException, IllegalAccessException {
		if (crud == null) {
			return null;
		}
		Field idField = null;
		try {
			idField = crud.getClass().getDeclaredField("id");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		if (idField != null) {
			boolean accessible = idField.canAccess(crud);
			idField.setAccessible(true);

			if (idField.getType().isAssignableFrom(EmpresaPadraoIdPK.class)) {
				EmpresaPadraoIdPK superEmpresaPK = (EmpresaPadraoIdPK) idField.get(crud);
				if (superEmpresaPK == null) {
					try {
						superEmpresaPK = new EmpresaPadraoIdPK(empresa,
								((id != null) ? Integer.parseInt(id.toString()) : null));
					} catch (NumberFormatException e) {
						superEmpresaPK = new EmpresaPadraoIdPK(empresa, null);
						System.out.println(
								"Número grande para converter para int (NumberFormatException): " + id.toString());
					}
				} else {
					superEmpresaPK.setEmpresa(empresa);
					if ((id != null)) {
						superEmpresaPK.setId(Integer.parseInt(id.toString()));
					}
				}
				idField.set(crud, superEmpresaPK);
			}
			idField.setAccessible(accessible);
		}
		return crud;
	}
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String getNomeTabelaEntidade(Class entity) {
		String name = null;
		Class superClass = entity.getSuperclass();
		if (superClass != null) {
			@SuppressWarnings("unchecked")
			Table table = (Table) superClass.getAnnotation(Table.class);
			if (table != null && table.name() != null && !table.name().isEmpty()) {
				return table.name();
			}

		}
		Table table = (Table) entity.getAnnotation(Table.class);
		if (table != null && table.name() != null && !table.name().isEmpty()) {
			if(table.schema() != null && !table.schema().isEmpty())
				name = table.schema()+"."+table.name();
			else
				name = table.name();
		} else {
			Entity entityAnnotation = (Entity) entity.getAnnotation(Entity.class);
			if (entityAnnotation != null && entityAnnotation.name() != null && !entityAnnotation.name().isEmpty()) {
				name = entityAnnotation.name();
			} else {
				name = entity.getSimpleName();
			}
		}
		return name;
	}
    
}

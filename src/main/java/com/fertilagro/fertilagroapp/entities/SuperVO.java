package com.fertilagro.fertilagroapp.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class SuperVO {
	
    public abstract void setGerarIdentificadorId(Integer id);

    public abstract Object getSuperId();
    
}

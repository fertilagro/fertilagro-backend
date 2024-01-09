package com.fertilagro.fertilagroapp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class SuperVO {
	
    public abstract void setGerarIdentificadorId(Integer id);
    
    public abstract String getLabelFkfield();

    public abstract Object getSuperId();
    
    @Transient
    @JsonProperty
    private Object dataKey;
    
}

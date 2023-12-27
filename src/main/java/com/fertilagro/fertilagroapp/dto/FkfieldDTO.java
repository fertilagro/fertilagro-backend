package com.fertilagro.fertilagroapp.dto;

import com.fertilagro.fertilagroapp.entities.SuperVO;

import lombok.Data;

@Data
public class FkfieldDTO<T extends SuperVO,C extends SuperDTO<T>> {
	private String label;
	private C value;

	public FkfieldDTO() {
		super();
	}
	
	public FkfieldDTO(C value) {
		if(value != null) {
			this.label = value.getLabelFkfield();
		}
		this.value = value;
	}
	
}

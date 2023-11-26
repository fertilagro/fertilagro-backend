package com.fertilagro.fertilagroapp.entities;

import jakarta.persistence.PostLoad;

public class SuperVO {

	@PostLoad
	public void setLabelFkField() {
	}
}

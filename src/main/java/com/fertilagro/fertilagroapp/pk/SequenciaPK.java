package com.fertilagro.fertilagroapp.pk;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class SequenciaPK {

	private Integer empresa;
	private String tabela;
	
}

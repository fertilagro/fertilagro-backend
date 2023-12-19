package com.fertilagro.fertilagroapp.pk;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SequenciaPK implements Serializable{

	private static final long serialVersionUID = 8990845130127664154L;
	
	private Integer empresa;
	private String tabela;
	
}

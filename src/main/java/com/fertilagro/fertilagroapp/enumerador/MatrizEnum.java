package com.fertilagro.fertilagroapp.enumerador;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fertilagro.fertilagroapp.util.EnumInterface;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum MatrizEnum implements EnumInterface {

	SOLO(0, "Solo"),
	FOLHA(1, "Folha"),
	FERTILIZANTES(2, "Fertilizantes"),
	CALCARIO(3, "Calcario"),
	PO_DE_ROCHA(4, "Po de rocha"),
	BROMATOLOGICA(5, "Bromatologica"),
	RESIDUAL(6, "Residual"),
	OUTRAS(7, "Outras");
	
    @Setter
    private Integer categoria;
    @Setter
    private String nome;

	@JsonCreator
    public static MatrizEnum forValue(String value) {
        for (MatrizEnum categoria : MatrizEnum.values()) {
            if (categoria.getNome().equals(value)) {
                return categoria;
            }
        }
        return null;
    }

    @JsonValue
    public String getNome() {
        return nome;
    }

    public static MatrizEnum verificaTipo(Integer s) {
        for (MatrizEnum categoria : MatrizEnum.values()) {
            if (categoria.getCategoria().equals(s)) {
                return categoria;
            }
        }
        throw new UnsupportedOperationException("A Matriz " + s + " não é Compatível.");
    }
}

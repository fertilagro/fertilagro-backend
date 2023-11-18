package com.fertilagro.fertilagroapp.enumerador;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fertilagro.fertilagroapp.util.EnumInterface;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum StatusEnum implements EnumInterface {

	ATIVO(0, "Ativo"),
	EXCLUIDO(1, "Excluído");
	
    @Setter
    private Integer categoria;
    @Setter
    private String nome;
    
    @JsonCreator
    public static StatusEnum forValue(String value) {
        for (StatusEnum categoria : StatusEnum.values()) {
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

    public static StatusEnum verificaTipo(Integer s) {
        for (StatusEnum categoria : StatusEnum.values()) {
            if (categoria.getCategoria().equals(s)) {
                return categoria;
            }
        }
        throw new UnsupportedOperationException("A Status " + s + " não é Compatível.");
    }
	
}

package com.fertilagro.fertilagroapp.enumerador;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum EstadoEnum {

	AC(0, "ACRE"),
	PA(1, "PARA"),
	AM(2, "AMAZONAS"),
	RR(3, "RORAIMA"),
	RO(4, "RONDÔNIA"),
	AP(5, "AMAPÁ"),
	TO(6, "TOCANTINS"),
	MA(7, "MARANHÃO"),
	PI(8, "PIAUÍ"),
	CE(9, "CEARÁ"),
	RN(10, "RIO GRANDE DO NORTE"),
	PB(11, "PARAÍBA"),
	PE(12, "PERNAMBUCO"),
	AL(13, "ALAGOAS"),
	SE(14, "SERGIPE"),
	BA(15, "BAHIA"),
	MG(16, "MINAS GERAIS"),
	ES(17, "ESPÍRITO SANTO"),
	RJ(18, "RIO DE JANEIRO"),
	SP(19, "SÃO PAULO"),
	PR(20, "PARANÁ"),
	SC(21, "SANTA CATARINA"),
	RS(22, "RIO GRANDE DO SUL"),
	MS(23, "MATO GROSSO DO SUL"),
	MT(24, "MATO GROSSO"),
	GO(25, "GOIÁS"),
	DF(26, "DISTRITO FEDERAL");

    @Setter
    private Integer categoria;
    @Setter
    private String nome;

	@JsonCreator
    public static EstadoEnum forValue(String value) {
        for (EstadoEnum categoria : EstadoEnum.values()) {
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

    public static EstadoEnum verificaTipo(Integer s) {
        for (EstadoEnum categoria : EstadoEnum.values()) {
            if (categoria.getCategoria().equals(s)) {
                return categoria;
            }
        }
        throw new UnsupportedOperationException("UF " + s + " não encontrada.");
    }
}

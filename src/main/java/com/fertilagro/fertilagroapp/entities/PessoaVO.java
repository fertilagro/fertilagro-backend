package com.fertilagro.fertilagroapp.entities;

import com.fertilagro.fertilagroapp.enumerador.StatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PessoaVO extends SuperVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Column(name = "RAZAOSOCIAL")
	private String razaoSocial;
    
    @Column(name="CNPJCPF")
    private String cnpjCpf;
	
    @Column(name="TELEFONE")
    private String telefone;
    
    @Column(name="EMAIL")
    private String email;
    
    @Column(name="ENDERECO")
    private String endereco;
    
    @Column(name="CIDADE")
    private String cidade;
    
    @Column(name = "STATUS")
	private StatusEnum status;
	
}

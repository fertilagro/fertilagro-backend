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
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PessoaVO {
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public StatusEnum getStatus() {
		return status;
	}

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
    
    @Column(name="ESTADO")
    private String estado;
    
    @Column(name = "STATUS")
	private StatusEnum status;

	
}

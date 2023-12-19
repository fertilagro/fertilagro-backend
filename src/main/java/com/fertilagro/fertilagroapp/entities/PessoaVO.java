package com.fertilagro.fertilagroapp.entities;

import com.fertilagro.fertilagroapp.enumerador.StatusEnum;
import com.fertilagro.fertilagroapp.pk.EmpresaPadraoIdPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
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

	@EmbeddedId
	private EmpresaPadraoIdPK id;
	
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

	@Override
	public void setGerarIdentificadorId(Integer id) {
        if (this.id != null) {
            this.id.setId(id);
        }
	}

	@Override
	public Object getSuperId() {
		if (this.id != null) {
			return this.id.getId();
		}
		return null;
	}
	
}

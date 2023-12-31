package com.fertilagro.fertilagroapp.entities;

import com.fertilagro.fertilagroapp.enumerador.StatusEnum;
import com.fertilagro.fertilagroapp.pk.EmpresaPadraoIdPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    
	@ManyToOne
	@JoinColumns(value = {
			@JoinColumn(name = "empresa", referencedColumnName = "empresa", insertable = false, updatable = false),
			@JoinColumn(name = "cidade", referencedColumnName = "id", insertable = false, updatable = false)})
	private CidadeVO cidade;
	@Column(name="CIDADE")
	private Integer cidadeId;
    
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

	@Override
	public String getLabelFkfield() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setCidade(CidadeVO cidade) {
		this.cidade = cidade;
		if (cidade != null) {
			setCidadeId(cidade.getSuperId());
		}
	}
	
}

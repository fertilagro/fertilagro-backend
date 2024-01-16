package com.fertilagro.fertilagroapp.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fertilagro.fertilagroapp.enumerador.StatusEnum;
import com.fertilagro.fertilagroapp.pk.EmpresaPadraoIdPK;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
public class PedidoVO extends SuperVO implements Serializable {

	private static final long serialVersionUID = -2449318246403973988L;

	@EmbeddedId
	private EmpresaPadraoIdPK id;
	
	@Column(name="DATA")
	private LocalDate data;

	@ManyToOne
	@JoinColumns(value = {
			@JoinColumn(name = "empresa", referencedColumnName = "empresa", insertable = false, updatable = false),
			@JoinColumn(name = "pessoa", referencedColumnName = "id", insertable = false, updatable = false)})
	private PessoaVO pessoa;
	@Column(name="PESSOA")
	private Integer pessoaId;
	
    @Column(name = "STATUS")
	private StatusEnum status;
	
	@OneToMany(mappedBy = "pedido", cascade=CascadeType.ALL)
	private List<PedidoAmostraVO> pedidoAmostras;
	
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
		return this.id != null ? this.id.getId().toString() : null;
	}
	
	public void setPessoa(PessoaVO pessoa) {
		this.pessoa = pessoa;
		if (pessoa != null) {
			setPessoaId(pessoa.getId().getId());
		}
	}
	
}

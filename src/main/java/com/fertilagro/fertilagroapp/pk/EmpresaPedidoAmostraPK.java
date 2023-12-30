package com.fertilagro.fertilagroapp.pk;

import java.io.Serializable;

import com.fertilagro.fertilagroapp.dto.pk.EmpresaPedidoAmostraPKDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class EmpresaPedidoAmostraPK implements Serializable {
	
	private static final long serialVersionUID = -873424085406501387L;

	@Column(name = "EMPRESA")
    private Integer empresa;

	@Column(name="PEDIDO")
	private Integer pedido;
	
    @Column(name = "ID")
    private Integer id;
    
    public EmpresaPedidoAmostraPK() {
    }
    
    public EmpresaPedidoAmostraPK(Integer empresa, Integer pedido, Integer id) {
    	this.empresa = empresa;
    	this.pedido = pedido;
    	this.id = id;
    }
    
    public EmpresaPedidoAmostraPK(EmpresaPedidoAmostraPKDTO empresaPedidoAmostraPKDTO) {
    	this.empresa = empresaPedidoAmostraPKDTO.getEmpresa();
    	this.pedido = empresaPedidoAmostraPKDTO.getPedido();
    	this.id = empresaPedidoAmostraPKDTO.getId();
    }
}

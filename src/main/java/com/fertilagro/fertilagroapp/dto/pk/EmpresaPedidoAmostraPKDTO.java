package com.fertilagro.fertilagroapp.dto.pk;

import com.fertilagro.fertilagroapp.pk.EmpresaPedidoAmostraPK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaPedidoAmostraPKDTO {

    private Integer empresa;
    private Integer pedido;
    private Integer id;
      
    public EmpresaPedidoAmostraPKDTO(EmpresaPedidoAmostraPK empresaPedidoAmostraPK) {
    	this.empresa = empresaPedidoAmostraPK.getEmpresa();
    	this.pedido = empresaPedidoAmostraPK.getPedido();
    	this.id = empresaPedidoAmostraPK.getId();
    }
}

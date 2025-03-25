package com.revisao.ecommerce.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDoPedidoDTO {
    private Long id;
    private Integer quantidade;
    private Double preco;
    private Long produtoId;
    private Long pedidoId;
}

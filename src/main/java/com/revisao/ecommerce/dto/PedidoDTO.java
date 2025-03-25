package com.revisao.ecommerce.dto;

import lombok.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private Instant momento;
    private String status;
    private Long usuarioId;
}

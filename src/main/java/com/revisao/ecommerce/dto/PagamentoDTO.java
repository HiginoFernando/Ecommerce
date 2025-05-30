package com.revisao.ecommerce.dto;

import lombok.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {
    private Long id;
    private Instant momento;
    private Long pedidoId;
}

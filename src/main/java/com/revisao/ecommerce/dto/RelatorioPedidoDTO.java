// src/main/java/com/revisao/ecommerce/dto/RelatorioPedidoDTO.java
package com.revisao.ecommerce.dto;

import com.revisao.ecommerce.entities.Pedido;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * DTO para relatório de pedidos, expondo todos os campos como Strings
 * (útil para JasperReports).
 */
public class RelatorioPedidoDTO {

    private Long pedidoId;
    private String clienteId;
    private String status;
    private String momento;

    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                         .withZone(ZoneId.systemDefault());

    public RelatorioPedidoDTO(Pedido pedido) {
        this.pedidoId = pedido.getId();

        // como não há relação direta com Cliente, usamos o campo clienteId
        this.clienteId = pedido.getClienteId() != null
            ? pedido.getClienteId().toString()
            : "Cliente não definido";

        // mapeia status a partir do Pagamento (se existir)
        if (pedido.getPagamento() != null && pedido.getPagamento().getStatus() != null) {
            this.status = pedido.getPagamento().getStatus();
        } else {
            this.status = "SEM PAGAMENTO";
        }

        Instant inst = pedido.getMomento();
        this.momento = inst != null
            ? FORMATTER.format(inst)
            : "";
    }

    /** Field "pedido" no JRXML */
    public Long getPedido() {
        return pedidoId;
    }

    /** Field "cliente" no JRXML */
    public String getCliente() {
        return clienteId;
    }

    /** Field "status" no JRXML */
    public String getStatus() {
        return status;
    }

    /** Field "momento" no JRXML */
    public String getMomento() {
        return momento;
    }
}

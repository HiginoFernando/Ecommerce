// src/main/java/com/revisao/ecommerce/entities/ItemDoPedidoPK.java
package com.revisao.ecommerce.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemDoPedidoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long pedidoId;
    private Long produtoId;

    public ItemDoPedidoPK() { }

    public ItemDoPedidoPK(Long pedidoId, Long produtoId) {
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDoPedidoPK that = (ItemDoPedidoPK) o;
        return Objects.equals(pedidoId, that.pedidoId) &&
               Objects.equals(produtoId, that.produtoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidoId, produtoId);
    }
}

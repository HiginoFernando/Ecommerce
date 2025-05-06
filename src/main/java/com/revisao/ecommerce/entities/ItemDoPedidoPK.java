package com.revisao.ecommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ItemDoPedidoPK {

    @ManyToOne
    @JoinColumn(name = "pedido_id")  
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id") 
    private Produto produto;

    
    public ItemDoPedidoPK() {
    }


    public ItemDoPedidoPK(Pedido pedido, Produto produto) {
        this.pedido = pedido;
        this.produto = produto;
    }

    // Getters e setters
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

  
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ItemDoPedidoPK that = (ItemDoPedidoPK) obj;
        return pedido.equals(that.pedido) && produto.equals(that.produto);
    }

    @Override
    public int hashCode() {
        return 31 * pedido.hashCode() + produto.hashCode();
    }
}

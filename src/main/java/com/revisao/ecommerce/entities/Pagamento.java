package com.revisao.ecommerce.entities;

import java.time.Instant;
import jakarta.persistence.*;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Instant momento;

    @Column(nullable = false)
    private String status;  
    @OneToOne
    @JoinColumn(name = "pedido_id") 
    private Pedido pedido;

    public Pagamento() { }

    public Pagamento(Instant momento, String status, Pedido pedido) {
        this.momento = momento;
        this.status = status;
        this.pedido = pedido;
    }

    // getters e setters

    public Long getId() {
        return id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}

package com.revisao.ecommerce.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pedido")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private Instant momento = Instant.now();

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Pagamento pagamento;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "pedido", "hibernateLazyInitializer", "handler" })
    private List<ItemDoPedido> itens = new ArrayList<>();

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    public Pedido() {}

    // getters e setters
    public Long getId() { return id; }
    public Instant getMomento() { return momento; }
    public void setMomento(Instant momento) { this.momento = momento; }
    public Pagamento getPagamento() { return pagamento; }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
        if (pagamento != null) pagamento.setPedido(this);
    }
    public List<ItemDoPedido> getItens() { return itens; }
    public void setItens(List<ItemDoPedido> itens) {
        this.itens = itens;
        itens.forEach(i -> i.setPedido(this));
    }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
}

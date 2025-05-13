package com.revisao.ecommerce.dto;

import java.io.Serializable;

public class ItemDoPedidoDTO implements Serializable {
    private Long id;
    private Long produtoId;
    private String nomeProduto;
    private Integer quantidade;
    private Double preco;

    public ItemDoPedidoDTO() {
    }

    public ItemDoPedidoDTO(Long id, Long produtoId, String nomeProduto, Integer quantidade, Double preco) {
        this.id = id;
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ItemDoPedidoDTO{" +
                "id=" + id +
                ", produtoId=" + produtoId +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}

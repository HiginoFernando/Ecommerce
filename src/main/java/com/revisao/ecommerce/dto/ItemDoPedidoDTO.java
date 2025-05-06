package com.revisao.ecommerce.dto;

public class ItemDoPedidoDTO {
    private Long clienteId;
    private String itens;
    private Long produtoId;
    private Integer quantidade;
    private Double preco;

    // Getters e Setters
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public String getItens() { return itens; }
    public void setItens(String itens) { this.itens = itens; }

    public Long getProdutoId() { return produtoId; }
    public void setProdutoId(Long produtoId) { this.produtoId = produtoId; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
}

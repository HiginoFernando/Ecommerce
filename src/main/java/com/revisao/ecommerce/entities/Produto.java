// src/main/java/com/revisao/ecommerce/entities/Produto.java
package com.revisao.ecommerce.entities;

import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produtos")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Double preco;

    private String imgUrl;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "produto_categoria",
        joinColumns = @JoinColumn(name = "produto_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<Categoria> categorias;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }

    public List<Categoria> getCategorias() { return categorias; }
    public void setCategorias(List<Categoria> categorias) { this.categorias = categorias; }
}

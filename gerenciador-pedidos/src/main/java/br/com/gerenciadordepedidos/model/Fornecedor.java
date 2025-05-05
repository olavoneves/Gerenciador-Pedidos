package br.com.gerenciadordepedidos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produto;

    public Fornecedor() {
    }

    public Long getId() {
        return id;
    }

    public Fornecedor setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public Fornecedor setProduto(List<Produto> produto) {
        this.produto = produto;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Fornecedor setNome(String nome) {
        this.nome = nome;
        return this;
    }
}

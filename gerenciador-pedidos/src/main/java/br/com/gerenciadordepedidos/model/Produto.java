package br.com.gerenciadordepedidos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @Column(name = "valor")
    private double preco;

    public Produto() {
    }

    public Produto(Long id, String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Produto setPreco(double preco) {
        this.preco = preco;
        return this;
    }
}

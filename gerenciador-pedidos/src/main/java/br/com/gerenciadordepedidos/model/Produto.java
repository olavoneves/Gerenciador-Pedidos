package br.com.gerenciadordepedidos.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne
    private Categoria categoria;
    @ManyToMany(mappedBy = "produto")
    private List<Pedido> pedido = new ArrayList<>();
    @ManyToOne
    private Fornecedor fornecedor;

    public Produto() {
    }

    public Produto(Long id, String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public Produto setId(Long id) {
        this.id = id;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Produto setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }


    public double getPreco() {
        return preco;
    }

    public Produto setPreco(double preco) {
        this.preco = preco;
        return this;
    }
}

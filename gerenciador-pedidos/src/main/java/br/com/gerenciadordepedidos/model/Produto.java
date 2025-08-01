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

    public Long getId() {
        return id;
    }

    public Produto setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public Produto setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
        return this;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public Produto setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
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

    @Override
    public String toString() {
        return "*****Produto*****\n" +
        "nome= '" + nome + '\'' +
        ", preco= " + preco +
        ", categoria= " + categoria;
    }
}

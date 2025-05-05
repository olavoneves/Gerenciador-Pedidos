package br.com.gerenciadordepedidos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @OneToMany(mappedBy = "categoria")
    private Produto produto;
    @ManyToOne
    private Pedido pedido;

    public Categoria() {
    }

    public Long getId() {
        return id;
    }

    public Categoria setId(Long id) {
        this.id = id;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public Categoria setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Categoria setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Categoria setNome(String nome) {
        this.nome = nome;
        return this;
    }
}

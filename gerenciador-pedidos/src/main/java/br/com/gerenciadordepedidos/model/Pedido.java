package br.com.gerenciadordepedidos.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate data;
    @OneToMany(mappedBy = "pedido")
    private Categoria categoria;
    @ManyToMany
    @JoinTable(name = "pedido_produto", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produto = new ArrayList<>();


    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public Pedido setId(Long id) {
        this.id = id;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Pedido setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public Pedido setProduto(List<Produto> produto) {
        this.produto = produto;
        return this;
    }

    public LocalDate getData() {
        return data;
    }

    public Pedido setData(LocalDate data) {
        this.data = data;
        return this;
    }
}

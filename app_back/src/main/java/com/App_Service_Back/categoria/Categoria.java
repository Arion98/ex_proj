package com.App_Service_Back.categoria;

import com.App_Service_Back.servicos.Servicos;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long categoria_id;
    private String categoria_nome;
    private String categoria_descricao;
    @OneToMany( fetch = FetchType.EAGER)
    private List<Servicos> servicos;


    public Categoria() {
    }

    public Categoria(Long categoria_id, String categoria_nome, String categoria_descricao) {
        this.categoria_id = categoria_id;
        this.categoria_nome = categoria_nome;
        this.categoria_descricao = categoria_descricao;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getCategoria_nome() {
        return categoria_nome;
    }

    public void setCategoria_nome(String categoria_nome) {
        this.categoria_nome = categoria_nome;
    }

    public String getCategoria_descricao() {
        return categoria_descricao;
    }

    public void setCategoria_descricao(String categoria_descricao) {
        this.categoria_descricao = categoria_descricao;
    }

    public List<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servicos> servicos) {
        this.servicos = servicos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(categoria_id, categoria.categoria_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoria_id);
    }

}

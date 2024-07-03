package com.App_Service_Back.endereco;

import com.App_Service_Back.cliente.Cliente;
import com.App_Service_Back.prestador.Prestadores;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endereco_id;
    private String endereco_rua;
    private String endereco_cep;
    @Column(unique = false)
    private Integer endereco_numero;
    private String endereco_complemento;
    private String endereco_cidade;
    private String endereco_estado;
    private String endereco_bairro;
    @JsonIgnore
    @OneToMany( fetch = FetchType.EAGER)
    private List<Cliente> clientes;
    @JsonIgnore
    @OneToMany( fetch = FetchType.EAGER)
    private List<Prestadores> prestadores;

    public Endereco() {
    }

    public Endereco(Long endereco_id, String endereco_rua, String endereco_cep, Integer endereco_numero, String endereco_complemento, String endereco_cidade, String endereco_estado, String endereco_bairro) {
        this.endereco_id = endereco_id;
        this.endereco_rua = endereco_rua;
        this.endereco_cep = endereco_cep;
        this.endereco_numero = endereco_numero;
        this.endereco_complemento = endereco_complemento;
        this.endereco_cidade = endereco_cidade;
        this.endereco_estado = endereco_estado;
        this.endereco_bairro = endereco_bairro;
    }

    public Long getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(Long endereco_id) {
        this.endereco_id = endereco_id;
    }

    public String getEndereco_rua() {
        return endereco_rua;
    }

    public void setEndereco_rua(String endereco_rua) {
        this.endereco_rua = endereco_rua;
    }

    public String getEndereco_cep() {
        return endereco_cep;
    }

    public void setEndereco_cep(String endereco_cep) {
        this.endereco_cep = endereco_cep;
    }

    public Integer getEndereco_numero() {
        return endereco_numero;
    }

    public void setEndereco_numero(Integer endereco_numero) {
        this.endereco_numero = endereco_numero;
    }

    public String getEndereco_complemento() {
        return endereco_complemento;
    }

    public void setEndereco_complemento(String endereco_complemento) {
        this.endereco_complemento = endereco_complemento;
    }

    public String getEndereco_cidade() {
        return endereco_cidade;
    }

    public void setEndereco_cidade(String endereco_cidade) {
        this.endereco_cidade = endereco_cidade;
    }

    public String getEndereco_estado() {
        return endereco_estado;
    }

    public void setEndereco_estado(String endereco_estado) {
        this.endereco_estado = endereco_estado;
    }

    public String getEndereco_bairro() {
        return endereco_bairro;
    }

    public void setEndereco_bairro(String endereco_bairro) {
        this.endereco_bairro = endereco_bairro;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Prestadores> getPrestadores() {
        return prestadores;
    }

    public void setPrestadores(List<Prestadores> prestadores) {
        this.prestadores = prestadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(endereco_id, endereco.endereco_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endereco_id);
    }

}

package com.App_Service_Back.prestador;

import com.App_Service_Back.endereco.Endereco;
import com.App_Service_Back.servicos.Servicos;
import com.App_Service_Back.telefone.Telefone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prestadores")
public class Prestadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long prestador_id;
    private  String prestador_nome;
    @Column(unique = true)
    private  String prestador_cnpj;
    @Column(unique = true)
    private  String prestador_cpf;
    private  String prestador_razaoSocial;
    @Column(unique = true)
    private  String prestador_email;
    private String prestador_senha;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Servicos> servicos;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prestador_endereco_id")
    private Endereco endereco;

    @OneToMany( fetch = FetchType.EAGER)
    private List<Telefone> telefones;

//    public Prestadores() {
//    }
//
//    public Prestadores(Long prestador_id, String prestador_nome, String prestador_cnpj, String prestador_cpf, String prestador_razaoSocial, String prestador_email, String prestador_senha, Endereco endereco) {
//        this.prestador_id = prestador_id;
//        this.prestador_nome = prestador_nome;
//        this.prestador_cnpj = prestador_cnpj;
//        this.prestador_cpf = prestador_cpf;
//        this.prestador_razaoSocial = prestador_razaoSocial;
//        this.prestador_email = prestador_email;
//        this.prestador_senha = prestador_senha;
//        this.endereco = endereco;
//    }
//
//    public Long getPrestador_id() {
//        return prestador_id;
//    }
//
//    public void setPrestador_id(Long prestador_id) {
//        this.prestador_id = prestador_id;
//    }
//
//    public String getPrestador_nome() {
//        return prestador_nome;
//    }
//
//    public void setPrestador_nome(String prestador_nome) {
//        this.prestador_nome = prestador_nome;
//    }
//
//    public String getPrestador_cnpj() {
//        return prestador_cnpj;
//    }
//
//    public void setPrestador_cnpj(String prestador_cnpj) {
//        this.prestador_cnpj = prestador_cnpj;
//    }
//
//    public String getPrestador_cpf() {
//        return prestador_cpf;
//    }
//
//    public void setPrestador_cpf(String prestador_cpf) {
//        this.prestador_cpf = prestador_cpf;
//    }
//
//    public String getPrestador_razaoSocial() {
//        return prestador_razaoSocial;
//    }
//
//    public void setPrestador_razaoSocial(String prestador_razaoSocial) {
//        this.prestador_razaoSocial = prestador_razaoSocial;
//    }
//
//    public String getPrestador_email() {
//        return prestador_email;
//    }
//
//    public void setPrestador_email(String prestador_email) {
//        this.prestador_email = prestador_email;
//    }
//
//    public String getPrestador_senha() {
//        return prestador_senha;
//    }
//
//    public void setPrestador_senha(String prestador_senha) {
//        this.prestador_senha = prestador_senha;
//    }
//
//    public List<Servicos> getServicos() {
//        return servicos;
//    }
//
//    public void setServicos(List<Servicos> servicos) {
//        this.servicos = servicos;
//    }
//
//    public Endereco getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(Endereco endereco) {
//        this.endereco = endereco;
//    }
//
//    public List<Telefone> getTelefones() {
//        return telefones;
//    }
//
//    public void setTelefones(List<Telefone> telefones) {
//        this.telefones = telefones;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Prestadores prestador = (Prestadores) o;
//        return Objects.equals(prestador_id, prestador.prestador_id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(prestador_id);
//    }
}

package com.App_Service_Back.servicos;

import com.App_Service_Back.agendamento.Agendamento;
import com.App_Service_Back.categoria.Categoria;
import com.App_Service_Back.endereco.Endereco;
import com.App_Service_Back.prestador.Prestadores;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicos")
public class Servicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servico_id;

    private String servico_nome;

    private Double servico_preco;

    private String servico_descricao;

    private String servico_informacoesExtras;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servico_categorias_id")
    private Categoria categorias;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servico_prestadores_id")
    private Prestadores prestadores;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Agendamento> agendamentos;

    private String servico_classificacao;


}

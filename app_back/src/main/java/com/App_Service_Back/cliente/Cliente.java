package com.App_Service_Back.cliente;
import com.App_Service_Back.agendamento.Agendamento;
import com.App_Service_Back.endereco.Endereco;
import com.App_Service_Back.servicos.Servicos;
import com.App_Service_Back.telefone.Telefone;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;
    private String cliente_nome;
    @Column(unique = true, nullable = false)
    private String cliente_cpf;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String cliente_senha;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate cliente_dataNascimento;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_endereco_id")
    private Endereco endereco;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Telefone> telefones;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Agendamento> agendamentos;
}



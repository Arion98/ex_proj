package com.App_Service_Back.agendamento;

import com.App_Service_Back.categoria.Categoria;
import com.App_Service_Back.cliente.Cliente;
import com.App_Service_Back.enums.StatusEnum;
import com.App_Service_Back.prestador.Prestadores;
import com.App_Service_Back.servicos.Servicos;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
@Entity
@Table(name = "agendamentos")
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long agendamento_id;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern ="dd/MM/yyyy")
    private LocalDate agendamento_data = LocalDate.now();
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern ="HH:mm")
    private LocalTime agendamento_hora;
    private String agendamento_observacoes;
    @Enumerated(EnumType.STRING)
    private StatusEnum agendamento_status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agendamento_cliente_id")
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agendamento_servico_id")
    private Servicos servicos;


    public Agendamento() {
    }

    public Agendamento(Long agendamento_id, LocalDate agendamento_data, LocalTime agendamento_hora, String agendamento_observacoes, StatusEnum agendamento_status, Cliente cliente, Servicos servicos) {
        this.agendamento_id = agendamento_id;
        this.agendamento_data = agendamento_data;
        this.agendamento_hora = agendamento_hora;
        this.agendamento_observacoes = agendamento_observacoes;
        this.agendamento_status = agendamento_status;
        this.cliente = cliente;
        this.servicos = servicos;
    }

    public Long getAgendamento_id() {
        return agendamento_id;
    }

    public void setAgendamento_id(Long agendamento_id) {
        this.agendamento_id = agendamento_id;
    }

    public LocalDate getAgendamento_data() {
        return agendamento_data;
    }

    public void setAgendamento_data(LocalDate agendamento_data) {
        this.agendamento_data = agendamento_data;
    }

    public LocalTime getAgendamento_hora() {
        return agendamento_hora;
    }

    public void setAgendamento_hora(LocalTime agendamento_hora) {
        this.agendamento_hora = agendamento_hora;
    }

    public String getAgendamento_observacoes() {
        return agendamento_observacoes;
    }

    public void setAgendamento_observacoes(String agendamento_observacoes) {
        this.agendamento_observacoes = agendamento_observacoes;
    }

    public StatusEnum getAgendamento_status() {
        return agendamento_status;
    }

    public void setAgendamento_status(StatusEnum agendamento_status) {
        this.agendamento_status = agendamento_status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(agendamento_id, that.agendamento_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agendamento_id);
    }

}

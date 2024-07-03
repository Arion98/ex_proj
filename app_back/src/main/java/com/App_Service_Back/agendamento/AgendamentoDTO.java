package com.App_Service_Back.agendamento;

import com.App_Service_Back.cliente.Cliente;
import com.App_Service_Back.enums.StatusEnum;
import com.App_Service_Back.servicos.Servicos;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long agendamento_id;

    @NotNull(message = "O campo DATA DE AGENDAMENTO é requerido")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate agendamento_data = LocalDate.now();

    @NotNull(message = "O campo HORA DE AGENDAMENTO é requerido")
    @JsonFormat(pattern ="HH:mm")
    private LocalTime agendamento_hora;


    private String agendamento_observacoes;


    private StatusEnum agendamento_status;

    @NotNull(message = "O campo CLIENTE é requerido")
    private Cliente cliente;


    @NotNull(message = "O campo SERVIÇOS é requerido")
    private Servicos servicos;
}

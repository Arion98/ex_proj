package com.App_Service_Back.agendamento;

import com.App_Service_Back.categoria.Categoria;
import com.App_Service_Back.categoria.CategoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendamentoMapper {
    @Mapping(source = "agendamento_id", target = "agendamento_id")
    AgendamentoDTO toDTO(Agendamento agendamento);
    @Mapping(source = "agendamentoDTO.agendamento_id", target = "agendamento_id")
    Agendamento toEntity(AgendamentoDTO agendamentoDTO);

    //recebendo lista de Agendamentos do banco em DTO
    List<AgendamentoDTO> toDTO(List<Agendamento> agendamentos);

    @Mappings({
            @Mapping(source = "agendamentoDTO.agendamento_id", target = "agendamento_id"),
            @Mapping(source = "agendamentoDTO.agendamento_data", target = "agendamento_data"),
            @Mapping(source = "agendamentoDTO.agendamento_hora", target = "agendamento_hora"),
            @Mapping(source = "agendamentoDTO.agendamento_observacoes", target = "agendamento_observacoes"),
            @Mapping(source = "agendamentoDTO.agendamento_status", target = "agendamento_status"),
            @Mapping(source = "agendamentoDTO.cliente", target = "cliente"),
            @Mapping(source = "agendamentoDTO.servicos", target = "servicos")
    })
    Agendamento updateEntity(AgendamentoDTO agendamentoDTO, Agendamento agendamento);
}

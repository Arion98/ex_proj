package com.App_Service_Back.servicos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicosMapper {
    @Mapping(source = "servico_id", target = "servico_id")
    ServicosDTO toDTO(Servicos servicos);
    @Mapping(source = "servicosDTO.servico_id", target = "servico_id")
    Servicos toEntity(ServicosDTO servicosDTO);

    //recebendo lista de servicos do banco em DTO
    List<ServicosDTO> toDTO(List<Servicos> servicos);

    @Mappings({
            @Mapping(source = "servicosDTO.servico_id", target = "servico_id"),
            @Mapping(source = "servicosDTO.servico_nome", target = "servico_nome"),
            @Mapping(source = "servicosDTO.servico_preco", target = "servico_preco"),
            @Mapping(source = "servicosDTO.servico_descricao", target = "servico_descricao"),
            @Mapping(source = "servicosDTO.servico_informacoesExtras", target = "servico_informacoesExtras"),
            @Mapping(source = "servicosDTO.categorias", target = "categorias"),
            @Mapping(source = "servicosDTO.prestadores", target = "prestadores"),
            @Mapping(source = "servicosDTO.servico_classificacao", target = "servico_classificacao"),
            @Mapping(source = "servicosDTO.agendamentos", target = "agendamentos"),
    })
    Servicos updateEntity(ServicosDTO servicosDTO, Servicos servicos);
}

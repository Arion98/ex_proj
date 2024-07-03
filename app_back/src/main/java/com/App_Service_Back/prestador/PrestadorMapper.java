package com.App_Service_Back.prestador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrestadorMapper {
    @Mapping(source = "prestador_id", target = "prestador_id")
    PrestadorDTO toDTO(Prestadores prestador);
    @Mapping(source = "prestadorDTO.prestador_id", target = "prestador_id")
    Prestadores toEntity(PrestadorDTO prestadorDTO);

    //recebendo lista de prestadores do banco em DTO
    List<PrestadorDTO> toDTO(List<Prestadores> prestadores);

    @Mappings({
            @Mapping(source = "prestadorDTO.prestador_id", target = "prestador_id"),
            @Mapping(source = "prestadorDTO.prestador_nome", target = "prestador_nome"),
            @Mapping(source = "prestadorDTO.prestador_cnpj", target = "prestador_cnpj"),
            @Mapping(source = "prestadorDTO.prestador_cpf", target = "prestador_cpf"),
            @Mapping(source = "prestadorDTO.prestador_razaoSocial", target = "prestador_razaoSocial"),
            @Mapping(source = "prestadorDTO.prestador_email", target = "prestador_email"),
            @Mapping(source = "prestadorDTO.prestador_senha", target = "prestador_senha"),
            @Mapping(source = "prestadorDTO.endereco", target = "endereco"),
            @Mapping(source = "prestadorDTO.servicos", target = "servicos"),
            @Mapping(source = "prestadorDTO.telefones", target = "telefones"),

    })
    Prestadores updateEntity(PrestadorDTO prestadorDTO, Prestadores prestador);
}

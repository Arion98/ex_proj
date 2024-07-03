package com.App_Service_Back.cliente;

import com.App_Service_Back.prestador.Prestadores;
import com.App_Service_Back.prestador.PrestadorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    @Mapping(source = "cliente_id", target = "cliente_id")
    ClienteDTO toDTO(Cliente cliente);
    @Mapping(source = "clienteDTO.cliente_id", target = "cliente_id")
    Cliente toEntity(ClienteDTO clienteDTO);

    //recebendo lista de prestadores do banco em DTO
    List<ClienteDTO> toDTO(List<Cliente> clientes);
    @Mappings({
            @Mapping(source = "clienteDTO.cliente_id", target = "cliente_id"),
            @Mapping(source = "clienteDTO.cliente_nome", target = "cliente_nome"),
            @Mapping(source = "clienteDTO.cliente_cpf", target = "cliente_cpf"),
            @Mapping(source = "clienteDTO.email", target = "email"),
            @Mapping(source = "clienteDTO.cliente_senha", target = "cliente_senha"),
            @Mapping(source = "clienteDTO.cliente_dataNascimento", target = "cliente_dataNascimento"),
            @Mapping(source = "clienteDTO.endereco", target = "endereco"),
            @Mapping(source = "clienteDTO.telefones", target = "telefones"),
            @Mapping(source = "clienteDTO.agendamentos", target = "agendamentos")
    })
    Cliente updateEntity(ClienteDTO clienteDTO, Cliente cliente);
}

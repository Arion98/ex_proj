package com.App_Service_Back.endereco;

import com.App_Service_Back.cliente.Cliente;
import com.App_Service_Back.prestador.Prestadores;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long endereco_id;
    @NotNull(message = "O campo RUA é requerido")
    private String endereco_rua;
    @NotNull(message = "O campo CEP é requerido")
    private String endereco_cep;
    @NotNull(message = "O campo NUMERO é requerido")
    private Integer endereco_numero;
    private String endereco_complemento;
    @NotNull(message = "O campo CIDADE é requerido")
    private String endereco_cidade;
    @NotNull(message = "O campo ESTADO é requerido")
    private String endereco_estado;
    @NotNull(message = "O campo BAIRRO é requerido")
    private String endereco_bairro;

    private List<Cliente> clientes;

    private List<Prestadores> prestadores;
}

package com.App_Service_Back.categoria;
import com.App_Service_Back.servicos.ServicosDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long categoria_id;

    @NotNull(message = "O campo NOME é requerido")
    private String categoria_nome;

    @NotNull(message = "O campo DESCRICAO é requerido")
    private String categoria_descricao;

    private List<ServicosDTO> servicos;
}

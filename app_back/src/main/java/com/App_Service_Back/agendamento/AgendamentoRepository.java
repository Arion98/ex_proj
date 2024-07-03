package com.App_Service_Back.agendamento;

import com.App_Service_Back.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
    //cria uma interface para ser implementada
}

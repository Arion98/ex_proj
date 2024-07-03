package com.App_Service_Back.servicos;

import com.App_Service_Back.prestador.Prestadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicosRepository extends JpaRepository<Servicos,Long> {
    //cria uma interface para ser implementada
    @Query("SELECT s FROM Servicos s WHERE s.servico_nome = :servicoNome")
    List<Servicos> findByServicoNome(@Param("servicoNome") String servicoNome);
}

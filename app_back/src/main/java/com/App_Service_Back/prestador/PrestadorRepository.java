package com.App_Service_Back.prestador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrestadorRepository extends JpaRepository<Prestadores,Long> {
    //cria uma interface para ser implementada
//    @Query("SELECT p FROM Prestador p WHERE p.servico.id = :servicoId")
//    List<Prestadores> findByServicoId(@Param("servicoId") Long servicoId);


}

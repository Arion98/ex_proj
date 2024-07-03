package com.App_Service_Back.cliente;

import com.App_Service_Back.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    //cria uma interface para ser implementada
    Optional<Cliente> findByEmail(String email);

}

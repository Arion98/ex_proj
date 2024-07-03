package com.App_Service_Back.telefone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone,Long> {
    //cria uma interface para ser implementada
}

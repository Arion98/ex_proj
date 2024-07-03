package com.App_Service_Back.endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
    //cria uma interface para ser implementada
}

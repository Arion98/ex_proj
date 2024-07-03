package com.App_Service_Back.cliente;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    // Getters and Setters
    private String email;
    private String cliente_senha;

}
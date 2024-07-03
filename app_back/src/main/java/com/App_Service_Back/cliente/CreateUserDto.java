package com.App_Service_Back.cliente;

import com.App_Service_Back.enums.RoleName;

public record CreateUserDto(

        String email,
        String password,
        RoleName role

) {
}

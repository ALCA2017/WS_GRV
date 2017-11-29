package com.ws.grv.dto.acceso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccederUsuario {

    private String email;
    private String contrasenia;

    public AccederUsuario(String email, String contrasenia) {
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public AccederUsuario() {
    }

}

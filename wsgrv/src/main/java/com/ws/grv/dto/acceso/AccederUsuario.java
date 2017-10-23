package com.ws.grv.dto.acceso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccederUsuario {

    private String usuario;
    private String contrasenia;

    public AccederUsuario(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public AccederUsuario() {
    }

}

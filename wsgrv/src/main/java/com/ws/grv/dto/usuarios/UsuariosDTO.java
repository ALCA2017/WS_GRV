package com.ws.grv.dto.usuarios;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuariosDTO {// implements Serializable {

    private String email;
    private String password;
    private String dni;
    private int idRol;
    private int idEstado;
    private int idUsuarioDetalles;

    public UsuariosDTO() {
    }

    public UsuariosDTO(String email, String password, String dni, int idRol, int idEstado, int idUsuarioDetalles) {
        this.email = email;
        this.password = password;
        this.dni = dni;
        this.idRol = idRol;
        this.idEstado = idEstado;
        this.idUsuarioDetalles = idUsuarioDetalles;
    }
    
}

package com.ws.grv.dto.usuarios;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuariosCompletoDTO {
    
    private String email;
    private String password;
    private String dni;
    private int idRol;
    private String rol;
    private int idEstado;
    private String estado;
    private int idUsuarioDetalles;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String sexo;
    private String telefonoFijo;
    private String telefonoMovil;

    public UsuariosCompletoDTO() {
    }

    public UsuariosCompletoDTO(String email, String password, String dni, int idRol, String rol, int idEstado, String estado, int idUsuarioDetalles, String nombres, String apellidoPaterno, String apellidoMaterno, String sexo, String telefonoFijo, String telefonoMovil) {
        this.email = email;
        this.password = password;
        this.dni = dni;
        this.idRol = idRol;
        this.rol = rol;
        this.idEstado = idEstado;
        this.estado = estado;
        this.idUsuarioDetalles = idUsuarioDetalles;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
    }
        
}

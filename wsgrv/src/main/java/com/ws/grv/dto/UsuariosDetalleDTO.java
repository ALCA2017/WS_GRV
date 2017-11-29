package com.ws.grv.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuariosDetalleDTO  implements Serializable {

    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String sexo;
    private String telefonoFijo;
    private String telefonoMovil;

    public UsuariosDetalleDTO() {
    }

    public UsuariosDetalleDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String sexo, String telefonoFijo, String telefonoMovil) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
    }


}

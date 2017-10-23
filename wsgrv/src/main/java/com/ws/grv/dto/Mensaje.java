package com.ws.grv.dto;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Mensaje implements Serializable {

    private int codigo;
    private String mensaje;
    private int tipo;

    public Mensaje() {
    }

    public Mensaje(int codigo, String mensaje, int tipo) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.tipo = tipo;
    }

}

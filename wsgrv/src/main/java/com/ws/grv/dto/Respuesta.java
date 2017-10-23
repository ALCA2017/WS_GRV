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
public class Respuesta implements Serializable {
// public class Respuesta extends RuntimeException {

    private static final long serialVersionUID = 1705575258348117223L;

    private Mensaje msj;
    private Object dato;

    public Respuesta() {
    }

    public Respuesta(Mensaje msj) {
        this.msj = msj;
    }

    public Respuesta(Mensaje msj, Object dato) {
        this.msj = msj;
        this.dato = dato;
    }

}

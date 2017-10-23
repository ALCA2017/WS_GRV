package com.ws.grv.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExceptionWsgrv extends RuntimeException {

    private String codigo;
    private Mensaje mensaje;

    public ExceptionWsgrv(String codigo) {
        this.codigo = codigo;
    }

    public ExceptionWsgrv(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        if (this.mensaje != null) {
            return this.mensaje.getMensaje();
        } else {
            return codigo;
        }
    }

}

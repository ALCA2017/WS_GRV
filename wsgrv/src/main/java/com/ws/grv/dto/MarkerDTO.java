package com.ws.grv.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarkerDTO{


    private int     idMarker;
    private String  nombre;
    private byte[]  imgPatternmat;
    private String  descripcion;
    private int     estado;
    private Date    fechaCreado;
    private Date    fechaActualizado;
    private int     idSesion;

    public MarkerDTO() {
    }

    public MarkerDTO(int idMarker, String nombre, byte[] imgPatternmat, int estado) {
        this.idMarker       = idMarker;
        this.nombre         = nombre;
        this.imgPatternmat  = imgPatternmat;
        this.estado         = estado;
    } 
    
}

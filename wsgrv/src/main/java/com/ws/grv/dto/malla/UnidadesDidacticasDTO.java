/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.dto.malla;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadesDidacticasDTO {
    
    private int idUnidadDidactica;
    private int nroUnidad;
    private String tituloUnidad;
    private int estado;
    private String fechaActualizado;

    public UnidadesDidacticasDTO() {
    }

    public UnidadesDidacticasDTO(int idUnidadDidactica, int nroUnidad, String tituloUnidad, int estado, String fechaActualizado) {
        this.idUnidadDidactica = idUnidadDidactica;
        this.nroUnidad = nroUnidad;
        this.tituloUnidad = tituloUnidad;
        this.estado = estado;
        this.fechaActualizado = fechaActualizado;
    }
    
}

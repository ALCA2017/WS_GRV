/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SesionesUnidadesAcademicasDTO {
    
    @Getter
    @Setter
    public static class DetalleSesion {
        private int idDetalle;
        private String indicadores;
        private String campoTematico;

        public DetalleSesion(int idDetalle, String indicadores, String campoTematico) {
            this.idDetalle = idDetalle;
            this.indicadores = indicadores;
            this.campoTematico = campoTematico;
        }

        @Override
        public String toString() {
            return "DetalleSesion{" + "idDetalle=" + idDetalle + ", indicadores=" + indicadores + ", campoTematico=" + campoTematico + '}';
        }
        
    }
    
    private int idSesion;
    private int idCursoAcademico;
    private String sesion;
    private String tituloSesion;
    private List<DetalleSesion> detallesSesion;
    private int estado;
    private String fechaActualizado;

    public SesionesUnidadesAcademicasDTO(int idSesion, int idCursoAcademico, String sesion, String tituloSesion, List<DetalleSesion> detallesSesion, int estado, String fechaActualizado) {
        this.idSesion = idSesion;
        this.idCursoAcademico = idCursoAcademico;
        this.sesion = sesion;
        this.tituloSesion = tituloSesion;
        this.detallesSesion = detallesSesion;
        this.estado = estado;
        this.fechaActualizado = fechaActualizado;
    }

    @Override
    public String toString() {
        return "SesionesUnidadesAcademicasDTO{" + "idSesion=" + idSesion + ", idCursoAcademico=" + idCursoAcademico + ", sesion=" + sesion + ", tituloSesion=" + tituloSesion + ", detallesSesion=" + detallesSesion + ", estado=" + estado + ", fechaActualizado=" + fechaActualizado + '}';
    }

}

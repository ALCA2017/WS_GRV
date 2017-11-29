/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnioAcademicoDTO {
    
    private int idAnioAcademico;
    private int anio;
    private String descripcion;
    private int estado;

    public AnioAcademicoDTO() {
    }

    public AnioAcademicoDTO(int idAnioAcademico, int anio, String descripcion, int estado) {
        this.idAnioAcademico = idAnioAcademico;
        this.anio = anio;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
}

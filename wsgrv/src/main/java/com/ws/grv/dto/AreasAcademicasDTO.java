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
public class AreasAcademicasDTO {
    
    private int idAreaAcademica;
    private String nombreArea;
    private String nombreCortoArea;

    public AreasAcademicasDTO() {
    }

    public AreasAcademicasDTO(int idAreaAcademica, String nombreArea, String nombreCortoArea) {
        this.idAreaAcademica = idAreaAcademica;
        this.nombreArea = nombreArea;
        this.nombreCortoArea = nombreCortoArea;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.AreasAcademicas;

/**
 *
 * @author vacpc
 */
public interface AreasAcademicasRepository {
    
    AreasAcademicas buscar_x_id_areas_academicas(int idAreasAcademicas) throws Exception;
}

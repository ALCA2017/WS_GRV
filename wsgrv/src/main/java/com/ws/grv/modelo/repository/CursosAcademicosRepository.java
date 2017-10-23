/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.CursosAcademicos;

/**
 *
 * @author vacpc
 */
public interface CursosAcademicosRepository {
    
    CursosAcademicos buscar_x_id_curso(int idCurso) throws Exception;
    
    CursosAcademicos buscar_x_id_area(int idArea) throws Exception;
    
}

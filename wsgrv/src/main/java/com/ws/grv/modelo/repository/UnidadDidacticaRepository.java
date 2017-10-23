/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.UnidadDidactica;
import java.util.List;

/**
 *
 * @author vacpc
 */
public interface UnidadDidacticaRepository {
   
    List<UnidadDidactica> listar_areas_academicas_x_anio_academico(int anioAcademico) throws Exception;
    
    List<UnidadDidactica> listar_unidades_x_areas(int idArea) throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.SesionUnidadDidactica;
import java.util.List;

/**
 *
 * @author vacpc
 */
public interface SesionUnidadDidacticaRepository {
    
    List<SesionUnidadDidactica> listar_sesiones_de_las_unidades_academicas_x_unidad_didactica(int idUnidadAcademica) throws Exception;
}

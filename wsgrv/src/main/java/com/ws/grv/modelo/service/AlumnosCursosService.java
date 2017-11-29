/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.service;

import com.ws.grv.dto.Usuarios_AlumnosCursosDTO;
import java.util.List;

/**
 *
 * @author vacpc
 */
public interface AlumnosCursosService {

    Usuarios_AlumnosCursosDTO Cursos_Area_Matriculados(int idUsuario, int idArea )throws Exception;
    
    Usuarios_AlumnosCursosDTO Cursos_x_Area(int idArea)throws Exception;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.Seccion;

/**
 *
 * @author vacpc
 */
public interface SeccionRepository {
    
    Seccion buscar_x_id_seccion(int idSeccion) throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.Nivel;

/**
 *
 * @author vacpc
 */
public interface NivelRepository {
    
    Nivel buscar_x_id_nivel(int idNivel) throws Exception;
}

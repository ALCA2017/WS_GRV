/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.NivGra;

/**
 *
 * @author vacpc
 */
public interface NivGraRepository {

    NivGra buscar_x_id(String idNivGra) throws Exception;
    
}

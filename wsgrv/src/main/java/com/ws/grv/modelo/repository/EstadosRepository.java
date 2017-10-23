/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.Estados;

/**
 *
 * @author vacpc
 */
public interface EstadosRepository {
 
    Estados buscar_rol_id(int idEstados) throws Exception;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.UsuariosDetalle;

/**
 *
 * @author vacpc
 */
public interface UsuarioDetallesRepository {
    
    UsuariosDetalle buscar_usuario_detalle_id(int idUsuarioDetalles) throws Exception;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.NivGraMatriculados;

/**
 *
 * @author vacpc
 */
public interface NivGraMatriculadosRepository {
    
    NivGraMatriculados buscar_x_id_usuario(int idUsuario) throws Exception;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.service;

import com.ws.grv.dto.Respuesta;
import com.ws.grv.dto.acceso.AccederUsuario;

/**
 *
 * @author vacpc
 */
public interface AccesoService {
    
    Respuesta authenticate(AccederUsuario accederUsuario) throws Exception;
    
}

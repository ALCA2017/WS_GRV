/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.service;

import com.ws.grv.dto.UsuariosCompletoDTO;
import com.ws.grv.modelo.entidades.Usuarios;
import java.util.List;

/**
 *
 * @author vacpc
 */
public interface UsuariosService {
    
    List<UsuariosCompletoDTO> usuario_a_mostrar() throws Exception;
    
}

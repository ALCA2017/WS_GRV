/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.DetalleSesion;
import java.util.List;

public interface DetalleSesionRepository {
    
    List<DetalleSesion> listar_detalles_de_sesiones_x_idSesion(int idSesion) throws Exception;
    
}

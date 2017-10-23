/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;
import com.ws.grv.modelo.entidades.Usuarios;
import java.util.List;

/**
 *
 * @author vacpc
 */
public interface UsuarioRepository {

    Usuarios acceder_usuario(String correo, String contrasenia) throws Exception;    
    
    boolean existe_correo(String correo) throws Exception;
    
    List<Usuarios> mostrar_usuarios() throws Exception;
    
    Usuarios buscar_x_id_usuario(int idUsuario) throws Exception;
    
}

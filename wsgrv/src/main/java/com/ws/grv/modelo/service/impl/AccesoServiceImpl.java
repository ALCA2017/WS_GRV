/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.service.impl;

import com.ws.grv.dto.Mensaje;
import com.ws.grv.dto.Respuesta;
import com.ws.grv.dto.acceso.AccederUsuario;
import com.ws.grv.modelo.entidades.Usuarios;
import com.ws.grv.modelo.entidades.util.AuxRepositorio;
import com.ws.grv.modelo.repository.UsuarioRepository;
import com.ws.grv.modelo.service.AccesoService;
import com.ws.grv.util.Encriptador;
import com.ws.grv.util.Validador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccesoServiceImpl implements AccesoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccesoServiceImpl.class);
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public Respuesta authenticate(AccederUsuario accederUsuario) throws Exception {
        
        try {
            
            String usuario                = accederUsuario.getEmail();
            String contrasenia            = accederUsuario.getContrasenia();
            String contrasenia_encriptada = Encriptador.encriptarTexto(contrasenia);
            
            // VALIDACIONES <-----------------------------------
            if ("".equals(usuario)){
                return new Respuesta(new Mensaje(AuxRepositorio.VALIDACION__NO_HA_INDICADO_UN_CORREO, "Debe indicar un usuario.", AuxRepositorio.TIPO_MENSAJE__CONFIRMACION));
            }
            if ("".equals(contrasenia)){
                return new Respuesta(new Mensaje(AuxRepositorio.VALIDACION__NO_HA_INDICADO_UNA_CONTRASEÑA,"Debe indicar una contraseña.", AuxRepositorio.TIPO_MENSAJE__CONFIRMACION));
            }
            if (!Validador.validateEmail(usuario)) {
                return new Respuesta(new Mensaje(AuxRepositorio.VALIDACION__CORREO_FORMATO_INVÁLIDO,"Formato incorrecto del Correo.", AuxRepositorio.TIPO_MENSAJE__CONFIRMACION));
            }

            Boolean bol = usuarioRepository.existe_correo(usuario);
            // List<UsuariosDTO> _usuarios = new ArrayList<>();                        
            if (!bol){
                    return new Respuesta(new Mensaje(AuxRepositorio.VALIDACION__CORREO_NO_REGISTRADO,"El correo [" + usuario + "] no esta registrado.", AuxRepositorio.TIPO_MENSAJE__CONFIRMACION));
            }
            Usuarios usuarios = usuarioRepository.acceder_usuario(usuario, contrasenia_encriptada); 
            if (usuarios == null) {
                // throw new ExceptionWsgrv(new Mensaje("", "La contraseña indicada es incorrecta.", AuxRepositorio.TIPO_MENSAJE__ERROR));
                return new Respuesta(new Mensaje(AuxRepositorio.VALIDACION__CONTRASEÑA_ERRÓNEA,"La contraseña indicada es incorrecta.", AuxRepositorio.TIPO_MENSAJE__CONFIRMACION));
            } else {
                // Envia RESPUESTA <---
                return new Respuesta(new Mensaje(AuxRepositorio.ACCESO__CONCEDIDO,"Bienvenido " + usuario + ".", AuxRepositorio.TIPO_MENSAJE__CONFIRMACION));
            }
            
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new Respuesta(new Mensaje(AuxRepositorio.ACCESO__DENEGADO,"[" + e + "]", AuxRepositorio.TIPO_MENSAJE__CONFIRMACION));
            // throw e;
        }
    }

}

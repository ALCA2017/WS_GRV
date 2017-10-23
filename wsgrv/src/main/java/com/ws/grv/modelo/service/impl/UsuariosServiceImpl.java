/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.service.impl;

import com.ws.grv.dto.usuarios.UsuariosCompletoDTO;
import com.ws.grv.modelo.entidades.Usuarios;
import com.ws.grv.modelo.repository.AreasAcademicasRepository;
import com.ws.grv.modelo.repository.CursosAcademicosRepository;
import com.ws.grv.modelo.repository.EstadosRepository;
import com.ws.grv.modelo.repository.GradoRepository;
import com.ws.grv.modelo.repository.NivGraDetallesRepository;
import com.ws.grv.modelo.repository.NivGraRepository;
import com.ws.grv.modelo.repository.NivelRepository;
import com.ws.grv.modelo.repository.RolesRepository;
import com.ws.grv.modelo.repository.SeccionRepository;
import com.ws.grv.modelo.repository.UsuarioDetallesRepository;
import com.ws.grv.modelo.repository.UsuarioRepository;
import com.ws.grv.modelo.service.UsuariosService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuariosServiceImpl.class);

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioDetallesRepository usuarioDetallesRepository;
    
    @Autowired
    private NivelRepository nivelRepository;
    
    @Autowired
    private GradoRepository gradoRepository;
    
    @Autowired
    private SeccionRepository seccionRepository;
    
    @Autowired
    private NivGraRepository nivGraRepository;
    
    @Autowired
    private NivGraDetallesRepository nivGraDetallesRepository;
    
    @Autowired
    private CursosAcademicosRepository cursosAcademicosRepository;
    
    @Autowired
    private AreasAcademicasRepository areasAcademicasRepository;
    
    @Autowired
    private RolesRepository rolesRepository;
    
    @Autowired
    private EstadosRepository estadosRepository;

    @Override
    public List<UsuariosCompletoDTO> usuario_a_mostrar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}

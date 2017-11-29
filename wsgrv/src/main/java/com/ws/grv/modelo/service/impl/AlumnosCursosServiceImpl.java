/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.service.impl;

import com.ws.grv.dto.ExceptionWsgrv;
import com.ws.grv.dto.Mensaje;
import com.ws.grv.dto.Usuarios_AlumnosCursosDTO;
import com.ws.grv.modelo.entidades.AreasAcademicas;
import com.ws.grv.modelo.entidades.CursosAcademicos;
import com.ws.grv.modelo.entidades.NivGra;
import com.ws.grv.modelo.entidades.NivGraDetalles;
import com.ws.grv.modelo.entidades.NivGraMatriculados;
import com.ws.grv.modelo.entidades.Seccion;
import com.ws.grv.modelo.entidades.Usuarios;
import com.ws.grv.modelo.entidades.UsuariosDetalle;
import com.ws.grv.modelo.entidades.util.AuxRepositorio;
import com.ws.grv.modelo.repository.AreasAcademicasRepository;
import com.ws.grv.modelo.repository.CursosAcademicosRepository;
import com.ws.grv.modelo.repository.EstadosRepository;
import com.ws.grv.modelo.repository.GradoRepository;
import com.ws.grv.modelo.repository.NivGraDetallesRepository;
import com.ws.grv.modelo.repository.NivGraMatriculadosRepository;
import com.ws.grv.modelo.repository.NivGraRepository;
import com.ws.grv.modelo.repository.NivelRepository;
import com.ws.grv.modelo.repository.RolesRepository;
import com.ws.grv.modelo.repository.SeccionRepository;
import com.ws.grv.modelo.repository.UsuarioDetallesRepository;
import com.ws.grv.modelo.repository.UsuarioRepository;
import com.ws.grv.modelo.service.AlumnosCursosService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnosCursosServiceImpl implements AlumnosCursosService {

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
    private NivGraMatriculadosRepository nivGraMatriculadosRepository;
    
    @Autowired
    private CursosAcademicosRepository cursosAcademicosRepository;
    
    @Autowired
    private AreasAcademicasRepository areasAcademicasRepository;
    
    @Autowired
    private RolesRepository rolesRepository;
    
    @Autowired
    private EstadosRepository estadosRepository;
    
    @Override
    public Usuarios_AlumnosCursosDTO Cursos_Area_Matriculados(int idUsuario, int idArea) throws Exception {
        try {
            if(idUsuario == 0){
                throw new ExceptionWsgrv(new Mensaje(AuxRepositorio.VALIDACION__NO_HA_INDICADO_UN_ID_USUARIO, "NO HA INDICADO UN ID DE USUARIO.", AuxRepositorio.TIPO_MENSAJE__ERROR));
            }
            
            if (idArea < 1 && idArea > 9) {
                throw new ExceptionWsgrv(new Mensaje(AuxRepositorio.VALIDACION__NO_HA_INDICADO_UN_ID_AREA, "NO HA INDICADO UN ID DE AREA.", AuxRepositorio.TIPO_MENSAJE__ERROR));
            }

            Usuarios usuario_encontrado = usuarioRepository.buscar_x_id_usuario(idUsuario);
            if(usuario_encontrado == null){
                throw new ExceptionWsgrv(new Mensaje(AuxRepositorio.VALIDACION__NO_SE_HA_ENCONTRADO_DATOS, "NO SE HA ENCONTRADO DATOS.", AuxRepositorio.TIPO_MENSAJE__ERROR));
            }

            NivGraMatriculados niv_gra_mat_datos = nivGraMatriculadosRepository.buscar_x_id_usuario(idUsuario);
            if(niv_gra_mat_datos == null){
                throw new ExceptionWsgrv(new Mensaje(AuxRepositorio.VALIDACION__EL_USUARIO_NO_ESTA_MATRICULADO, "EL USUARIO INDICADO NO ESTA MATRICULADO.", AuxRepositorio.TIPO_MENSAJE__ERROR));
            }

            NivGra nivGra = nivGraRepository.buscar_x_id(niv_gra_mat_datos.getIdNivGra().getIdNivGra());
            if(nivGra == null){
                throw new ExceptionWsgrv(new Mensaje(AuxRepositorio.VALIDACION__EL_USUARIO_NO_ESTA_MATRICULADO, "NO SE ENCONTRO EL NIVEL Y GRADO.", AuxRepositorio.TIPO_MENSAJE__ERROR));
            }            

            // Llenando DTO a ENVIAR al FRONTEND. ---------------------------- INICIO
            Usuarios_AlumnosCursosDTO datos_a_enviar_DTO = new Usuarios_AlumnosCursosDTO();
                datos_a_enviar_DTO.setEmail(usuario_encontrado.getEmail());
                datos_a_enviar_DTO.setNivel(niv_gra_mat_datos.getIdNivel().getNivel());
                datos_a_enviar_DTO.setGrado(niv_gra_mat_datos.getIdGrado().getGrado());
                datos_a_enviar_DTO.setSeccion(niv_gra_mat_datos.getIdSeccion().getSeccion());
                
            // Muestra los idNivGraDet - idCurso - idNivGra
            List<NivGraDetalles> nivGraDetalles = nivGraDetallesRepository.listar_niv_gra_detalles_x_id(niv_gra_mat_datos.getIdNivGra().getIdNivGra(), idArea);
            if(nivGraDetalles == null){
                throw new ExceptionWsgrv(new Mensaje(AuxRepositorio.VALIDACION__EL_USUARIO_NO_ESTA_MATRICULADO, "NO SE ENCONTRO CURSOS Y AREAS DETALLES.", AuxRepositorio.TIPO_MENSAJE__ERROR));
            }
            // Almacenará 1 curso encontrado
            List<Usuarios_AlumnosCursosDTO.ListaCursosAreas> list = new ArrayList<>();
            
                // Recorrerá los cursos encontrados por 'idNivGRA'
                for (NivGraDetalles nivGraDetalle : nivGraDetalles) {
                    Usuarios_AlumnosCursosDTO.ListaCursosAreas listCA = new Usuarios_AlumnosCursosDTO.ListaCursosAreas();
                    int _idArea = nivGraDetalle.getIdCurso().getIdAreaAcademica().getIdAreaAcademica();
                    if (_idArea == idArea) {
                        // Muestra los detalles del idCurso encontrado                    
                        listCA.setIdCurso(nivGraDetalle.getIdCurso().getIdCursoAcademico());
                        listCA.setCurso(nivGraDetalle.getIdCurso().getNombreCurso());
                        listCA.setIdArea(_idArea);
                        listCA.setArea(nivGraDetalle.getIdCurso().getIdAreaAcademica().getNombreArea());
                    }
                    // Guarda los 4 datos en esta LISTA
                    list.add(listCA);
                }
                // Llenando DTO a ENVIAR al FRONTEND. ---------------------------- CONTINUA
                datos_a_enviar_DTO.setListaCursosAreas(list);

            return datos_a_enviar_DTO;    
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }        
    }

    @Override
    public Usuarios_AlumnosCursosDTO Cursos_x_Area(int idArea) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

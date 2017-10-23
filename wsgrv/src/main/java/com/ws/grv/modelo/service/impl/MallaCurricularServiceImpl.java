/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.service.impl;

import com.ws.grv.dto.ExceptionWsgrv;
import com.ws.grv.dto.Mensaje;
import com.ws.grv.dto.malla.AnioAcademicoDTO;
import com.ws.grv.dto.malla.AreasAcademicasDTO;
import com.ws.grv.dto.malla.SesionesUnidadesAcademicasDTO;
import com.ws.grv.dto.malla.UnidadesDidacticasDTO;
import com.ws.grv.modelo.entidades.AnioAcademico;
import com.ws.grv.modelo.entidades.DetalleSesion;
import com.ws.grv.modelo.entidades.SesionUnidadDidactica;
import com.ws.grv.modelo.entidades.UnidadDidactica;
import com.ws.grv.modelo.entidades.util.AuxRepositorio;
import com.ws.grv.modelo.repository.AnioAcademicoRepository;
import com.ws.grv.modelo.repository.DetalleSesionRepository;
import com.ws.grv.modelo.repository.SesionUnidadDidacticaRepository;
import com.ws.grv.modelo.repository.UnidadDidacticaRepository;
import com.ws.grv.modelo.service.MallaCurricularService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MallaCurricularServiceImpl implements MallaCurricularService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuariosServiceImpl.class);
    
    @Autowired
    private UnidadDidacticaRepository unidadDidacticaRepository;
    
    @Autowired
    private SesionUnidadDidacticaRepository sesionUnidadDidacticaRepository;
    
    @Autowired
    private DetalleSesionRepository detalleSesionRepository;
    
    @Autowired
    private AnioAcademicoRepository anioAcademicoRepository;
    
    @Override
    public List<AreasAcademicasDTO> listar_areas_academicas_x_anio_academico(int anioAcademico) throws Exception {
        try {
            if(anioAcademico == 0){
                throw new ExceptionWsgrv(new Mensaje(AuxRepositorio.VALIDACION__NO_HA_INDICADO_UN_ANIO_ESCOLAR, "NO HA INDICADO UN AÑO ACADÉMICO.", AuxRepositorio.TIPO_MENSAJE__ERROR));
            }
            
            List<UnidadDidactica> unidadDidactica = unidadDidacticaRepository.listar_areas_academicas_x_anio_academico(anioAcademico);
            if(unidadDidactica == null){
                throw new ExceptionWsgrv(new Mensaje(AuxRepositorio.VALIDACION__NO_SE_ENCONTRO_VALORES, "NO SE ENCONTRARON DATOS.", AuxRepositorio.TIPO_MENSAJE__ERROR));
            }
            
            //Almacenará las AREAS encontradas
            List<AreasAcademicasDTO> lista_areasAcademicasDTOs = new ArrayList<>();
            
            for (UnidadDidactica ud : unidadDidactica){
                AreasAcademicasDTO aa = new AreasAcademicasDTO();
                aa.setIdAreaAcademica(ud.getIdAreaAcademica().getIdAreaAcademica());
                aa.setNombreArea(ud.getIdAreaAcademica().getNombreArea());
                aa.setNombreCortoArea(ud.getIdAreaAcademica().getNombreCortoArea());
                
                lista_areasAcademicasDTOs.add(aa);
            }
            return lista_areasAcademicasDTOs;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<UnidadesDidacticasDTO> listar_unidades_x_areas(int idArea) throws Exception {
        try {
            if(idArea == 0){
                throw new ExceptionWsgrv(new Mensaje(AuxRepositorio.VALIDACION__NO_HA_INDICADO_UN_ANIO_ESCOLAR, "NO HA INDICADO UN AREA.", AuxRepositorio.TIPO_MENSAJE__ERROR));
            }
            List<UnidadDidactica> unidadDidactica = unidadDidacticaRepository.listar_unidades_x_areas(idArea);
            if(unidadDidactica == null){
                throw new ExceptionWsgrv(new Mensaje(AuxRepositorio.VALIDACION__NO_SE_ENCONTRO_VALORES, "NO SE ENCONTRARON DATOS.", AuxRepositorio.TIPO_MENSAJE__ERROR));
            }
            
            //Almacenará las AREAS encontradas
            List<UnidadesDidacticasDTO> unidadesDidacticasDTOs = new ArrayList<>();
            
            for (UnidadDidactica ud : unidadDidactica){
                UnidadesDidacticasDTO aa = new UnidadesDidacticasDTO();
                aa.setIdUnidadDidactica(ud.getIdUnidadDidactica());
                aa.setNroUnidad(ud.getNroUnidad());
                aa.setTituloUnidad(ud.getTituloUnidad());
                aa.setEstado(ud.getEstado());                
                aa.setFechaActualizado(ud.getFechaActualizado().toString());
                
                unidadesDidacticasDTOs.add(aa);
            }
            return unidadesDidacticasDTOs;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SesionesUnidadesAcademicasDTO> listar_sesiones_de_las_unidades_academicas_x_unidad_didactica(int idUnidadAcademica) throws Exception {
        try {
            if(idUnidadAcademica == 0){
                throw new ExceptionWsgrv(new Mensaje(AuxRepositorio.VALIDACION__NO_HA_INDICADO_UNA_UNIDAD_ACADEMICA, "NO HA INDICADO UNA UNIDAD ACADEMICA.", AuxRepositorio.TIPO_MENSAJE__ERROR));
            }            
            List<SesionUnidadDidactica> sesionUnidadDidacticas = sesionUnidadDidacticaRepository.listar_sesiones_de_las_unidades_academicas_x_unidad_didactica(idUnidadAcademica);
            
            List<SesionesUnidadesAcademicasDTO> sesionesUnidadesAcademicasDTOs = new ArrayList<>();
            List<SesionesUnidadesAcademicasDTO.DetalleSesion> sesionesUnidadesAcademicasDTOs_detalleSesion = new ArrayList<>();
            
            for (SesionUnidadDidactica sesionUnidadDidactica : sesionUnidadDidacticas) {
                List<DetalleSesion> detalleSesions = detalleSesionRepository.listar_detalles_de_sesiones_x_idSesion(sesionUnidadDidactica.getIdSesion());
                
                for (DetalleSesion detalleSesion : detalleSesions){
                    SesionesUnidadesAcademicasDTO.DetalleSesion bb = new SesionesUnidadesAcademicasDTO.DetalleSesion(detalleSesion.getIdDetalleSesion(), detalleSesion.getIndicadores(), detalleSesion.getCampoTematico());
//                    bb.setIdDetalle(detalleSesion.getIdDetalleSesion());
//                    bb.setIndicadores(detalleSesion.getIndicadores());
//                    bb.setCampoTematico(detalleSesion.getCampoTematico());                    
                    sesionesUnidadesAcademicasDTOs_detalleSesion.add(bb);
                }

                SesionesUnidadesAcademicasDTO aa = new SesionesUnidadesAcademicasDTO(
                        sesionUnidadDidactica.getIdSesion(), 
                        sesionUnidadDidactica.getIdCursoAcademico(), 
                        sesionUnidadDidactica.getSesion(), 
                        sesionUnidadDidactica.getTituloSesion(), 
                        sesionesUnidadesAcademicasDTOs_detalleSesion, 
                        sesionUnidadDidactica.getEstado(), 
                        sesionUnidadDidactica.getFechaActualizado().toString());
//                aa.setIdSesion(sesionUnidadDidactica.getIdSesion());
//                aa.setIdCursoAcademico(sesionUnidadDidactica.getIdCursoAcademico());
//                aa.setSesion(sesionUnidadDidactica.getSesion());
//                aa.setTituloSesion(sesionUnidadDidactica.getTituloSesion());
//                aa.setDetallesSesion(sesionesUnidadesAcademicasDTOs_detalleSesion);
//                aa.setEstado(sesionUnidadDidactica.getEstado());
//                aa.setFechaActualizado(sesionUnidadDidactica.getFechaActualizado().toString());                
                sesionesUnidadesAcademicasDTOs.add(aa);
            }
                                
            return sesionesUnidadesAcademicasDTOs;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<AnioAcademicoDTO> listar_anio_academico() throws Exception {
        try {
            List<AnioAcademico> academicos = anioAcademicoRepository.listar_anio_academico();
            
            if(academicos == null){
                throw new ExceptionWsgrv(new Mensaje(AuxRepositorio.VALIDACION__NO_SE_ENCONTRO_VALORES, "NO SE ENCONTRARON DATOS.", AuxRepositorio.TIPO_MENSAJE__ERROR));
            }
            
            List<AnioAcademicoDTO> academicoDTOs = new ArrayList<>();
            
            for (AnioAcademico academico : academicos) {
                AnioAcademicoDTO academicoDTO = new AnioAcademicoDTO();
                academicoDTO.setIdAnioAcademico(academico.getIdAnioAcademico());
                academicoDTO.setAnio(academico.getAnio());
                academicoDTO.setDescripcion(academico.getDescripcion());
                academicoDTO.setEstado(academico.getEstado());
                
                academicoDTOs.add(academicoDTO);
            }
            return academicoDTOs;            
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }
    
}

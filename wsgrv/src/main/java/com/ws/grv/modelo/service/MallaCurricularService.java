/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.service;

import com.ws.grv.dto.malla.AnioAcademicoDTO;
import com.ws.grv.dto.malla.AreasAcademicasDTO;
import com.ws.grv.dto.malla.SesionesUnidadesAcademicasDTO;
import com.ws.grv.dto.malla.UnidadesDidacticasDTO;
import java.util.List;

/**
 *
 * @author vacpc
 */
public interface MallaCurricularService {
    
    List<AreasAcademicasDTO> listar_areas_academicas_x_anio_academico(int anioAcademico) throws Exception;
    
    List<UnidadesDidacticasDTO> listar_unidades_x_areas(int idArea) throws Exception;
    
    List<SesionesUnidadesAcademicasDTO> listar_sesiones_de_las_unidades_academicas_x_unidad_didactica(int idUnidadAcademica) throws Exception;
    
    List<AnioAcademicoDTO> listar_anio_academico() throws Exception;
    
}

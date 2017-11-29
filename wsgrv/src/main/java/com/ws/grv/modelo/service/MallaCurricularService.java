package com.ws.grv.modelo.service;

import com.ws.grv.dto.AnioAcademicoDTO;
import com.ws.grv.dto.AreasAcademicasDTO;
import com.ws.grv.dto.TemasUnidadDidacticaDTO;
import com.ws.grv.dto.UnidadesDidacticasDTO;
import java.util.List;

public interface MallaCurricularService {
    
    public List<AreasAcademicasDTO> listar_areas_academicas_x_anio_academico(int anioAcademico) throws Exception;
    
    public List<UnidadesDidacticasDTO> listar_unidades_x_areas(int idArea) throws Exception;
    
    //public List<SesionesUnidadesAcademicasDTO> listar_sesiones_de_las_unidades_academicas_x_unidad_didactica(int idUnidadAcademica) throws Exception;
    
    public List<AnioAcademicoDTO> listar_anio_academico() throws Exception;
    
    public List<TemasUnidadDidacticaDTO> getTemas_Recursos_UD(int idUnidadDidactica);
}

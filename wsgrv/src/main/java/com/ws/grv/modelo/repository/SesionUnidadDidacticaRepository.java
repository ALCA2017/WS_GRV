package com.ws.grv.modelo.repository;

import com.ws.grv.dto.TemasUnidadDidacticaDTO;
import java.util.List;

public interface SesionUnidadDidacticaRepository {
    
   // List<SesionUnidadDidactica> listar_sesiones_de_las_unidades_academicas_x_unidad_didactica(int idUnidadAcademica) throws Exception;
    public List<TemasUnidadDidacticaDTO> getTemas_Recursos_UD(int idUnidadDidactica);
}

package com.ws.grv.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemasUnidadDidacticaDTO {
    
    private Integer id_sesion;	
    private Integer id_curso_academico;
    private String  sesion;
    private String  titulo_sesion;
    private String  indicadores;
    private String  campo_tematico;
    private Integer estado;
    private Date    fecha_Actualizado;
    private Integer nroIMG;
    private Integer nroVIDEO;
    private Integer nroWEB;
   
    public TemasUnidadDidacticaDTO() {
    }    
    
    public TemasUnidadDidacticaDTO(Integer id_sesion, Integer id_curso_academico, String sesion, String titulo_sesion,
                    String indicadores, String campo_tematico, Integer estado, Date fecha_Actualizado, Integer nroIMG,
                    Integer nroVIDEO, Integer nroWEB) {
            this.id_sesion = id_sesion;
            this.id_curso_academico = id_curso_academico;
            this.sesion = sesion;
            this.titulo_sesion = titulo_sesion;
            this.indicadores = indicadores;
            this.campo_tematico = campo_tematico;
            this.estado = estado;
            this.fecha_Actualizado = fecha_Actualizado;
            this.nroIMG = nroIMG;
            this.nroVIDEO = nroVIDEO;
            this.nroWEB = nroWEB;
    }    
    
}

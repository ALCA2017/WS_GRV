package com.ws.grv.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecursoImgDTO {

    private Integer idRecursoImg;
    private String  result;
    private String  text;
    private String  url;
    private String  referencia1;
    private String  referencia2;
    private Integer estado;
    private Date    fechaActualizado;
    private Integer idSesion;

    public RecursoImgDTO() {
    }
    
    public RecursoImgDTO(Integer id_recurso_img, Integer id_sesion, String result, String text, String uRL,
			String rEFERENCIA1, String rEFERENCIA2, Integer estado, Date fecha_actualizado) {
		this.idRecursoImg 	= id_recurso_img;
		this.idSesion 		= id_sesion;
		this.result 		= result;
		this.text 		= text;
		this.url 		= uRL;
		this.referencia1 	= rEFERENCIA1;
		this.referencia2 	= rEFERENCIA2;
		this.estado 		= estado;
		this.fechaActualizado	= fecha_actualizado;
	}

    public RecursoImgDTO(Integer id_sesion, String result, String text, String uRL) {
		this.idSesion   = id_sesion;
		this.result 	= result;
		this.text 	= text;
		this.url 	= uRL;
	}    
}

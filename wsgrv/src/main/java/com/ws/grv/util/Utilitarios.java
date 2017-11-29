package com.ws.grv.util;

import java.text.SimpleDateFormat;
import java.util.Date;
 
public class Utilitarios {
    
    /* AAAA/MM/DD : format PostgresSQL*/
     public Date getFechaActual() {

        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date hoy = java.sql.Date.valueOf(formateador.format(ahora));    	
        return hoy;
    }    

}

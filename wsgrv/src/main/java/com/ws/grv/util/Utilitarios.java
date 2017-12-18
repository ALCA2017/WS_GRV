package com.ws.grv.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
public class Utilitarios {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Utilitarios.class);
    
    
    /* AAAA/MM/DD : format PostgresSQL*/
     public Date getFechaActual() {

        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date hoy = java.sql.Date.valueOf(formateador.format(ahora));    	
        return hoy;
    }   
     
    public static byte[] ImageToByte(File file) throws FileNotFoundException{
    
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);      
                //System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        byte[] bytes = bos.toByteArray();
     
     return bytes; 
    }     

}

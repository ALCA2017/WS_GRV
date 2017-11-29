package com.ws.grv.modelo.service;

import com.ws.grv.dto.RecursoImgDTO;
import com.ws.grv.dto.RecursoVideoDTO;
import com.ws.grv.dto.RecursoWwwDTO;
import com.ws.grv.modelo.entidades.RecursoImg;
import com.ws.grv.modelo.entidades.RecursoVideo;
import com.ws.grv.modelo.entidades.RecursoWww;
import java.util.List;


public interface RecursosService {

    public List<RecursoVideoDTO> getRecursosVideosList(int idTema);

    public List<RecursoImgDTO> getRecursosImagenList(int idTema);

    public List<RecursoWwwDTO> getRecursosWebList(int idTema);	

    public void addVideo(RecursoVideo video);

    public void addImagen(RecursoImg imagen);

    public void addWeb(RecursoWww web);
    
}

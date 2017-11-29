package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.RecursoImg;
import com.ws.grv.modelo.entidades.RecursoVideo;
import com.ws.grv.modelo.entidades.RecursoWww;
import java.util.List;

public interface RecursosRepository {
    
    public List<RecursoImg> getRecursoImagenByTemaId(int idTema);

    public List<RecursoVideo> getRecursoVideoByTemaId(int idTema);

    public List<RecursoWww> getRecursoWebByTemaId(int idTema);

    public void insertVideo(RecursoVideo video);

    public void insertImagen(RecursoImg imagen);

    public void insertWeb(RecursoWww web);    
    
}

package com.ws.grv.modelo.service.impl;

import com.ws.grv.dto.RecursoImgDTO;
import com.ws.grv.dto.RecursoVideoDTO;
import com.ws.grv.dto.RecursoWwwDTO;
import com.ws.grv.modelo.entidades.RecursoImg;
import com.ws.grv.modelo.entidades.RecursoVideo;
import com.ws.grv.modelo.entidades.RecursoWww;
import com.ws.grv.modelo.repository.RecursosRepository;
import com.ws.grv.modelo.service.RecursosService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecursosServiceImpl implements RecursosService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuariosServiceImpl.class);
    
    @Autowired
    private RecursosRepository repository;
    
    @Override
    public List<RecursoVideoDTO> getRecursosVideosList(int idTema) {
        try {
            List<RecursoVideo> recursoVideo =  repository.getRecursoVideoByTemaId(idTema);

            List<RecursoVideoDTO> lista_RecursoVideoDTOs = new ArrayList<>(); 
            for (RecursoVideo ud : recursoVideo){
                RecursoVideoDTO rv = new RecursoVideoDTO();
                rv.setIdRecursoVideo(ud.getIdRecursoVideo());
                rv.setResult(ud.getResult());
                rv.setText(ud.getText());
                rv.setUrl(ud.getUrl());
                rv.setReferencia1(ud.getReferencia1());
                rv.setReferencia2(ud.getReferencia2());
                rv.setEstado(ud.getEstado());
                rv.setFechaActualizado(ud.getFechaActualizado());
                rv.setIdSesion(Integer.parseInt(ud.getIdSesion().toString()));
                
                lista_RecursoVideoDTOs.add(rv);
            }
            return lista_RecursoVideoDTOs;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<RecursoImgDTO> getRecursosImagenList(int idTema) {
        
        try {
            List<RecursoImg> recursoImg =  repository.getRecursoImagenByTemaId(idTema);

            List<RecursoImgDTO> lista_RecursoImgDTOs = new ArrayList<>();
            
            for (RecursoImg ud : recursoImg){
                
                RecursoImgDTO rv = new RecursoImgDTO();
                
                rv.setIdRecursoImg(ud.getIdRecursoImg());
                rv.setResult(ud.getResult());
                rv.setText(ud.getText());
                rv.setUrl(ud.getUrl());
                rv.setReferencia1(ud.getReferencia1());
                rv.setReferencia2(ud.getReferencia2());
                rv.setEstado(ud.getEstado());
                rv.setFechaActualizado(ud.getFechaActualizado());                
                rv.setIdSesion(Integer.parseInt(ud.getIdSesion().toString()));
                
                lista_RecursoImgDTOs.add(rv);
            }
            return lista_RecursoImgDTOs;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }        
    }

    @Override
    public List<RecursoWwwDTO> getRecursosWebList(int idTema) {

        try {
            List<RecursoWww> recursoVideo =  repository.getRecursoWebByTemaId(idTema);

            List<RecursoWwwDTO> lista_RecursoWwwDTOs = new ArrayList<>();
            
            for (RecursoWww ud : recursoVideo){
                
                RecursoWwwDTO rv = new RecursoWwwDTO();
                
                rv.setIdRecursoWww(ud.getIdRecursoWww());
                rv.setResult(ud.getResult());
                rv.setText(ud.getText());
                rv.setUrl(ud.getUrl());
                rv.setReferencia1(ud.getReferencia1());
                rv.setReferencia2(ud.getReferencia2());
                rv.setEstado(ud.getEstado());
                rv.setFechaActualizado(ud.getFechaActualizado());
                rv.setIdSesion(Integer.parseInt(ud.getIdSesion().toString()));
                
                lista_RecursoWwwDTOs.add(rv);
            }
            return lista_RecursoWwwDTOs;
            
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }        
    }

    @Override
    public void addVideo(RecursoVideo video) {
        repository.insertVideo(video);
    }

    @Override
    public void addImagen(RecursoImg imagen) {
        repository.insertImagen(imagen);
    }

    @Override
    public void addWeb(RecursoWww web) {
        repository.insertWeb(web);
    }
    
}

package com.ws.grv.modelo.service.impl;

import com.ws.grv.dto.MarkerDTO;
import com.ws.grv.dto.RecursoVideoDTO;
import com.ws.grv.modelo.entidades.Marker;
import com.ws.grv.modelo.entidades.RecursoVideo;
import com.ws.grv.modelo.repository.MarkerRepository;
import com.ws.grv.modelo.repository.RecursosRepository;
import com.ws.grv.modelo.service.MarkerService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkerServiceImpl implements MarkerService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MarkerServiceImpl.class);
    
    @Autowired
    private MarkerRepository repository;    

    @Override
    public List<MarkerDTO> getMarkerList(int idTema) {
        try {
            List<Marker> mark =  repository.getMarkerByTemaId(idTema);

            List<MarkerDTO> lista_MarkerDTOs = new ArrayList<>(); 
            for (Marker ud : mark){
                MarkerDTO rv = new MarkerDTO();
                rv.setIdMarker(ud.getIdMarker());
                rv.setIdSesion(Integer.parseInt(ud.getIdSesion().toString()));
                rv.setNombre(ud.getNombre());
                rv.setImgPatternmat(ud.getImgPatternmat());
                rv.setDescripcion(ud.getDescripcion());                
                rv.setEstado(ud.getEstado());
                rv.setFechaCreado(ud.getFechaCreado());
                rv.setFechaActualizado(ud.getFechaActualizado());
                lista_MarkerDTOs.add(rv);
            }
            return lista_MarkerDTOs;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void addMarker(Marker marker) {
        repository.insertMarker(marker);
    }

    @Override
    public void addMarker(Marker marker, String ruta) {
        repository.insertMarker(marker, ruta);
    } 
    
}

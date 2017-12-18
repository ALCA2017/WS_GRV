package com.ws.grv.modelo.service;

import com.ws.grv.dto.MarkerDTO;
import com.ws.grv.modelo.entidades.Marker;
import java.util.List;

public interface MarkerService {
    
    public List<MarkerDTO> getMarkerList(int idTema);

    public void addMarker(Marker marker);	    
    
    public void addMarker(Marker marker, String ruta);	    
    
}

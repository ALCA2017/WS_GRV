package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.Marker;
import java.util.List;

public interface MarkerRepository {

    public List<Marker> getMarkerByTemaId(int idTema);

    public void insertMarker(Marker marker);	    
    
    public void insertMarker(Marker marker, String ruta);	    
    
}

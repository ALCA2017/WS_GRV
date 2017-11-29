package com.ws.grv.web.controller;

import com.ws.grv.dto.MarkerDTO;
import com.ws.grv.modelo.entidades.Marker;
import com.ws.grv.modelo.entidades.SesionUnidadDidactica;
import com.ws.grv.modelo.service.MarkerService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins = "*", methods = {GET, POST, PUT})
@RequestMapping("/pattern")
public class MarkerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarkerController.class);
    
    @Autowired
    MarkerService manager;

    //http://localhost:8455/pattern/markerlist?idTema=1
     @RequestMapping(value = "/markerlist", method = RequestMethod.GET)
     public @ResponseBody List<MarkerDTO> getMarkerList(@RequestParam int idTema) {

             List<MarkerDTO> videoList =manager.getMarkerList(idTema); 

      return videoList;  
     } 


    //http://localhost:8455/pattern/marker/create?id_sesion=id_sesion&nombre=nombre&img_patternMat=img_patternMat&descripcion=descripcion
     @RequestMapping(value = "/marker/create", method = RequestMethod.GET)
     public @ResponseBody void createMarker(@RequestParam(value = "id_sesion", required = true) int id_sesion,
                                            @RequestParam(value = "nombre", required = true) String nombre,
                                            @RequestParam(value = "img_patternMat", required = true) byte[] img_patternMat,
                                            @RequestParam(value = "descripcion", required = true) String descripcion) {

             SesionUnidadDidactica sesion = new SesionUnidadDidactica();
             sesion.setIdSesion(id_sesion);                            
             Marker marker = new Marker(sesion, nombre, img_patternMat, descripcion);
             manager.addMarker(marker);
     }
	      
    
}

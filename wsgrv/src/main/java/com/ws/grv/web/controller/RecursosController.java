package com.ws.grv.web.controller;

import com.ws.grv.dto.RecursoImgDTO;
import com.ws.grv.dto.RecursoVideoDTO;
import com.ws.grv.dto.RecursoWwwDTO;
import com.ws.grv.modelo.entidades.RecursoImg;
import com.ws.grv.modelo.entidades.RecursoVideo;
import com.ws.grv.modelo.entidades.RecursoWww;
import com.ws.grv.modelo.entidades.SesionUnidadDidactica;
import com.ws.grv.modelo.service.RecursosService;
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
@RequestMapping("/recursos")
public class RecursosController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuariosController.class);
    
    @Autowired
    RecursosService manager;

     //http://localhost:8455/recursos/videolist?idTema=1
     @RequestMapping(value = "/videolist", method = RequestMethod.GET)
     public @ResponseBody List<RecursoVideoDTO> getVideoList(@RequestParam int idTema) {

             List<RecursoVideoDTO> videoList =manager.getRecursosVideosList(idTema); 

      return videoList;  
     } 

     //http://localhost:8455/recursos/imagenlist?idTema=1
     @RequestMapping(value = "/imagenlist", method = RequestMethod.GET)
     public @ResponseBody List<RecursoImgDTO> getImagenList(@RequestParam int idTema) {

             List<RecursoImgDTO> imagenList =manager.getRecursosImagenList(idTema); 

      return imagenList;  
     }  

     //http://localhost:8455/recursos/weblist?idTema=1
     @RequestMapping(value = "/weblist", method = RequestMethod.GET)
     public @ResponseBody List<RecursoWwwDTO> getWebList(@RequestParam int idTema) {		 
             List<RecursoWwwDTO> webList =manager.getRecursosWebList(idTema); 	  
      return webList;  
     }  	

     @RequestMapping(value = "/video/create", method = RequestMethod.GET)
     public @ResponseBody String videoCreate(@RequestParam(value = "Idsesion", required = true) int Idsesion,
                                                       @RequestParam(value = "Result", required = true) String Result,
                                                       @RequestParam(value = "Text", required = true) String Text,							   
                                                       @RequestParam(value = "URL", required = true) String URL) {
             System.out.println("Controller Guardar Video.........");
             SesionUnidadDidactica sesion = new SesionUnidadDidactica();
             sesion.setIdSesion(Idsesion);               
             RecursoVideo video =  new RecursoVideo(sesion, Result, Text, URL);
            //RecursoVideo video = null;
            manager.addVideo(video);
         return "";
     }

     @RequestMapping(value = "/imagen/create", method = RequestMethod.GET)
     public @ResponseBody String imagenCreate(@RequestParam(value = "Idsesion", required = true) int Idsesion,
                                                            @RequestParam(value = "Result", required = true) String Result,
                                                            @RequestParam(value = "Text", required = true) String Text,
                                                            @RequestParam(value = "URL", required = true) String URL) {
             System.out.println("Controller Guardar Imagen.........");
             SesionUnidadDidactica sesion = new SesionUnidadDidactica();
             sesion.setIdSesion(Idsesion);
             RecursoImg imagen =new RecursoImg(sesion, Result, Text, URL);
             manager.addImagen(imagen);
         return "";
     }

     @RequestMapping(value = "/web/create", method = RequestMethod.GET)
     public @ResponseBody String webCreate(@RequestParam(value = "Idsesion", required = true) int Idsesion,
                                                     @RequestParam(value = "Result", required = true) String Result,
                                                     @RequestParam(value = "Text", required = true) String Text,
                                                     @RequestParam(value = "URL", required = true) String URL) {
             System.out.println("Controller Guardar Web.........");
             SesionUnidadDidactica sesion = new SesionUnidadDidactica();
             sesion.setIdSesion(Idsesion);             
             RecursoWww web = new RecursoWww(sesion, Result, Text, URL);
             manager.addWeb(web);
         return "";
     }	 
	     
    
}

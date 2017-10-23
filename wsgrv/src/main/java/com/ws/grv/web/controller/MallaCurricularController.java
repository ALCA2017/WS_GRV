/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.web.controller;

import com.ws.grv.dto.malla.AnioAcademicoDTO;
import com.ws.grv.dto.malla.AreasAcademicasDTO;
import com.ws.grv.dto.malla.SesionesUnidadesAcademicasDTO;
import com.ws.grv.dto.malla.UnidadesDidacticasDTO;
import com.ws.grv.dto.usuarios.Usuarios_AlumnosCursosDTO;
import com.ws.grv.modelo.service.AlumnosCursosService;
import com.ws.grv.modelo.service.MallaCurricularService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {GET, POST, PUT})
@RequestMapping("/malla")
public class MallaCurricularController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AccesoController.class);
    
    @Autowired
    private AlumnosCursosService alumnosCursosService;
    
    @Autowired
    private MallaCurricularService mallaCurricularService;
    
    @RequestMapping(value = "/cursos/academicos", method = RequestMethod.GET)
    public ResponseEntity lista_cursos_academicos(@RequestParam("idUsuario") int idUsuario, @RequestParam("idArea") int idArea) {
        try {
            Usuarios_AlumnosCursosDTO r = this.alumnosCursosService.Cursos_Area_Matriculados(idUsuario, idArea);
            return new ResponseEntity(r, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/areas/academicas", method = RequestMethod.GET)
    public ResponseEntity lista_areas_academicas(@RequestParam("anioAcademico") int anioAcademico) {
        try {
            List<AreasAcademicasDTO> r = this.mallaCurricularService.listar_areas_academicas_x_anio_academico(anioAcademico);
            return new ResponseEntity(r, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/unidades/didacticas", method = RequestMethod.GET)
    public ResponseEntity lista_unidades_didacticas(@RequestParam("idAreaAcademica") int idAreaAcademica) {
        try {
            List<UnidadesDidacticasDTO> r = this.mallaCurricularService.listar_unidades_x_areas(idAreaAcademica);
            return new ResponseEntity(r, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/areas/unidades/sesiones", method = RequestMethod.GET)
    public ResponseEntity lista_areas_unidades_sesiones(@RequestParam("idUnidadAcademica") int idUnidadAcademica) {
        try {
            List<SesionesUnidadesAcademicasDTO> r = this.mallaCurricularService.listar_sesiones_de_las_unidades_academicas_x_unidad_didactica(idUnidadAcademica);
            return new ResponseEntity(r, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/anios/academicos", method = RequestMethod.GET)
    public ResponseEntity lista_anios_academicos() {
        try {
            List<AnioAcademicoDTO> r = this.mallaCurricularService.listar_anio_academico();
            return new ResponseEntity(r, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}

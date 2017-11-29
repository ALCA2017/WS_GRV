/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.web.controller;

import com.ws.grv.modelo.service.AlumnosCursosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {GET, POST, PUT})
@RequestMapping("/alumno")
public class AlumnosController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AlumnosController.class);
    
    @Autowired
    private AlumnosCursosService alumnosCursosService;    
    
       /*
    @RequestMapping(value = "/cursos/academicos", method = RequestMethod.GET)
    public ResponseEntity lista_cursos_academicos(@RequestParam("idUsuario") int idUsuario, @RequestParam("idArea") int idArea) {
        try {
            Usuarios_AlumnosCursosDTO r = this.alumnosCursosService.Cursos_Area_Matriculados(idUsuario, idArea);
            return new ResponseEntity(r, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.OK);
        }
    }*/
    
}

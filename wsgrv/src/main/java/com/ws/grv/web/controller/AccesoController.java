/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.web.controller;

import com.ws.grv.dto.Respuesta;
import com.ws.grv.dto.acceso.AccederUsuario;
import com.ws.grv.modelo.service.AccesoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vacpc
 */
@RestController
@CrossOrigin(origins = "*", methods = {GET, POST, PUT})
@RequestMapping("/api")
public class AccesoController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AccesoController.class);
    
    @Autowired
    private AccesoService accesoService;
    
    @RequestMapping(value = "/user/authenticate", method = RequestMethod.POST)
    public ResponseEntity acceder_usuario(@RequestBody AccederUsuario accederUsuario) {
        try {
            Respuesta r = this.accesoService.authenticate(accederUsuario);
            return new ResponseEntity(r, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
    
}

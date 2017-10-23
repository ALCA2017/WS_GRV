/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;

import com.ws.grv.modelo.entidades.AnioAcademico;
import java.util.List;

/**
 *
 * @author vacpc
 */
public interface AnioAcademicoRepository {

    List<AnioAcademico> listar_anio_academico() throws Exception;    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository;


import com.ws.grv.modelo.entidades.CursosAcademicos;
import com.ws.grv.modelo.entidades.NivGraDetalles;
import java.util.List;

/**
 *
 * @author vacpc
 */
public interface NivGraDetallesRepository {
    
    NivGraDetalles buscar_x_id_niv_gra(int idNivGra) throws Exception;
    
    List<NivGraDetalles> listar_niv_gra_detalles_x_id(String idNivGra, int idArea) throws Exception;
    
    List<NivGraDetalles> listar_busqueda_x_idnivgra_idarea(String idNivGra, int idArea) throws Exception;
    
}

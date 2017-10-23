/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository.impl;

import com.ws.grv.modelo.entidades.SesionUnidadDidactica;
import com.ws.grv.modelo.entidades.SesionUnidadDidactica_;
import com.ws.grv.modelo.entidades.UnidadDidactica;
import com.ws.grv.modelo.entidades.UnidadDidactica_;
import com.ws.grv.modelo.repository.SesionUnidadDidacticaRepository;
import com.ws.grv.modelo.repository.UsuarioRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SesionUnidadDidacticaRepositoryImpl implements SesionUnidadDidacticaRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepository.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<SesionUnidadDidactica> listar_sesiones_de_las_unidades_academicas_x_unidad_didactica(int idUnidadAcademica) throws Exception {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<SesionUnidadDidactica> root = cq.from(SesionUnidadDidactica.class);
            
            cq.select(root).
                where(cb.equal(
                        root.get(SesionUnidadDidactica_.idUnidadDidactica), idUnidadAcademica));
            Query query = entityManager.createQuery(cq);
            List<SesionUnidadDidactica> sud = query.getResultList();
            return sud;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

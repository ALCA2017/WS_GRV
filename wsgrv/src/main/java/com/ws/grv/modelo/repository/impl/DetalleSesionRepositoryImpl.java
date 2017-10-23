/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository.impl;

import com.ws.grv.modelo.entidades.DetalleSesion;
import com.ws.grv.modelo.entidades.DetalleSesion_;
import com.ws.grv.modelo.repository.DetalleSesionRepository;
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
public class DetalleSesionRepositoryImpl implements DetalleSesionRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(DetalleSesionRepository.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<DetalleSesion> listar_detalles_de_sesiones_x_idSesion(int idSesion) throws Exception {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<DetalleSesion> root = cq.from(DetalleSesion.class);
            
            cq.select(root).
                where(cb.equal(
                        root.get(DetalleSesion_.idSesion), idSesion));
            Query query = entityManager.createQuery(cq);
            List<DetalleSesion> sud = query.getResultList();
            return sud;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }
    
}

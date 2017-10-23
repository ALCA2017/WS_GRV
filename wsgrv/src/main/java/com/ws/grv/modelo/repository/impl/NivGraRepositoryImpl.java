/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository.impl;

import com.ws.grv.modelo.entidades.NivGra;
import com.ws.grv.modelo.entidades.NivGra_;
import com.ws.grv.modelo.repository.NivGraRepository;
import com.ws.grv.modelo.repository.UsuarioRepository;
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
public class NivGraRepositoryImpl implements NivGraRepository {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepository.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public NivGra buscar_x_id(String idNivGra) throws Exception {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<NivGra> root = cq.from(NivGra.class);
            
            cq.select(root).where(
                cb.equal(root.get(NivGra_.idNivGra), idNivGra)
            );
            
            Query q = entityManager.createQuery(cq);
            Object obj = null;
            try {
                obj = q.getSingleResult();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
            return obj != null ? (NivGra) obj : null;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }
    
}

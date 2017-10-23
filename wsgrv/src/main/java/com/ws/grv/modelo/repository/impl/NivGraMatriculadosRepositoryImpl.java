/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository.impl;

import com.ws.grv.modelo.entidades.Estados;
import com.ws.grv.modelo.entidades.Estados_;
import com.ws.grv.modelo.entidades.NivGraMatriculados;
import com.ws.grv.modelo.entidades.NivGraMatriculados_;
import com.ws.grv.modelo.repository.NivGraMatriculadosRepository;
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
public class NivGraMatriculadosRepositoryImpl implements NivGraMatriculadosRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepository.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public NivGraMatriculados buscar_x_id_usuario(int idUsuario) throws Exception {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<NivGraMatriculados> root = cq.from(NivGraMatriculados.class);
            
            cq.select(root).where(
                cb.equal(root.get(NivGraMatriculados_.idUsuario), idUsuario)
            );
            
            Query q = entityManager.createQuery(cq);
            Object obj = null;
            try {
                obj = q.getSingleResult();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
            return obj != null ? (NivGraMatriculados) obj : null;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }
    
}

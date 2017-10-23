/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository.impl;

import com.ws.grv.modelo.entidades.AnioAcademico;
import com.ws.grv.modelo.entidades.AnioAcademico_;
import com.ws.grv.modelo.entidades.DetalleSesion;
import com.ws.grv.modelo.entidades.DetalleSesion_;
import com.ws.grv.modelo.repository.AnioAcademicoRepository;
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
public class AnioAcademicoRepositoryImpl implements AnioAcademicoRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepository.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<AnioAcademico> listar_anio_academico() throws Exception {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<AnioAcademico> root = cq.from(AnioAcademico.class);
            
            cq.select(root);
            
            Query query = entityManager.createQuery(cq);
            List<AnioAcademico> sud = query.getResultList();
            return sud;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }
    
}

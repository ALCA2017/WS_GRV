/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository.impl;

import com.ws.grv.modelo.entidades.UnidadDidactica;
import com.ws.grv.modelo.entidades.UnidadDidactica_;
import com.ws.grv.modelo.repository.UnidadDidacticaRepository;
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
public class UnidadDidacticaRepositoryImpl implements UnidadDidacticaRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UnidadDidactica> listar_areas_academicas_x_anio_academico(int anioAcademico) throws Exception {
        try {
        // 1er METODO 
//            String jpql = "SELECT r.idAreaAcademica, r.nombreArea, r.nombreCortoArea FROM bd_wsgrv.areasAcademicas r INNER JOIN bd_wsgrv.unidadDidactica u ON r.idAreaAcademica = u.idAreaAcademica WHERE u.idAnioAcademico = (SELECT idAnioAcademico FROM bd_wsgrv.anioAcademico WHERE anio = " + anioAcademico + ")";
//            Query query = entityManager.createQuery(jpql);

        // 2do METODO 
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<UnidadDidactica> root = cq.from(UnidadDidactica.class);
            
            cq.select(root).
                where(cb.equal(
                        root.get(UnidadDidactica_.idAnioAcademico), anioAcademico));
            Query query = entityManager.createQuery(cq);
            
            List<UnidadDidactica> uds = query.getResultList();
            return uds;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UnidadDidactica> listar_unidades_x_areas(int idArea) throws Exception {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<UnidadDidactica> root = cq.from(UnidadDidactica.class);
            
            cq.select(root).
                where(cb.and(
                    cb.equal(root.get(UnidadDidactica_.idAreaAcademica), idArea),
                    cb.equal(root.get(UnidadDidactica_.estado), 1)
                ));
            Query query = entityManager.createQuery(cq);
            
            List<UnidadDidactica> uds = query.getResultList();
            return uds;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

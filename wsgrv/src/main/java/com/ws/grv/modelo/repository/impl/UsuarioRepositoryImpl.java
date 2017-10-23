/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository.impl;

import com.ws.grv.modelo.entidades.Usuarios;
import com.ws.grv.modelo.entidades.Usuarios_;
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
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepository.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Usuarios acceder_usuario(String correo, String contrasenia) throws Exception {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<Usuarios> root = cq.from(Usuarios.class);
            
            cq.select(root).where(
                cb.equal(root.get(Usuarios_.email), correo),
                cb.equal(root.get(Usuarios_.password), contrasenia)
            );
            
            Query query = entityManager.createQuery(cq);
            Object obj = null;
            try {
                obj = query.getSingleResult();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
            return obj != null ? (Usuarios) obj : null;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public boolean existe_correo(String correo) throws Exception {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<Usuarios> root = cq.from(Usuarios.class);
            
            cq.select(root).where(
                cb.equal(root.get(Usuarios_.email), correo)
            );
            
            
            Query query = entityManager.createQuery(cq);
            Object obj = null;
            try {
                obj = query.getSingleResult();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
            Usuarios usuarios = null;
            if (obj != null){
                usuarios = (Usuarios) obj;
            }
            return usuarios != null;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Usuarios> mostrar_usuarios() throws Exception {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<Usuarios> root = cq.from(Usuarios.class);
            
            cq.select(root);
            
            Query q = entityManager.createQuery(cq);
            
            return q.getResultList();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Usuarios buscar_x_id_usuario(int idUsuario) throws Exception {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<Usuarios> root = cq.from(Usuarios.class);
            
            cq.select(root).where(
                cb.equal(root.get(Usuarios_.usuarioId), idUsuario)
            );
            
            Query q = entityManager.createQuery(cq);
            Object obj = null;
            try {
                obj = q.getSingleResult();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
            return obj != null ? (Usuarios) obj : null;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }
    
}

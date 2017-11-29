package com.ws.grv.modelo.repository.impl;

import com.ws.grv.modelo.entidades.RecursoImg;
import com.ws.grv.modelo.entidades.RecursoImg_;
import com.ws.grv.modelo.entidades.RecursoVideo;
import com.ws.grv.modelo.entidades.RecursoVideo_;
import com.ws.grv.modelo.entidades.RecursoWww;
import com.ws.grv.modelo.entidades.RecursoWww_;
import com.ws.grv.modelo.repository.RecursosRepository;
import com.ws.grv.util.Utilitarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RecursosRepositoryImpl implements RecursosRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(RecursosRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;    
    
    Utilitarios util = new Utilitarios();
    
    @Override
    public List<RecursoImg> getRecursoImagenByTemaId(int idTema){
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<RecursoImg> root = cq.from(RecursoImg.class);
            
            cq.select(root).
                where(cb.and(
                    cb.equal(root.get(RecursoImg_.idSesion), idTema),
                    cb.equal(root.get(RecursoImg_.estado), 1)
                ));
            Query query = entityManager.createQuery(cq);
            
            List<RecursoImg> uds = query.getResultList();
            return uds;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<RecursoVideo> getRecursoVideoByTemaId(int idTema) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<RecursoVideo> root = cq.from(RecursoVideo.class);
            
            cq.select(root).
                where(cb.and(
                    cb.equal(root.get(RecursoVideo_.idSesion), idTema),
                    cb.equal(root.get(RecursoVideo_.estado), 1)
                ));
            Query query = entityManager.createQuery(cq);
            
            List<RecursoVideo> uds = query.getResultList();
            return uds;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<RecursoWww> getRecursoWebByTemaId(int idTema) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<RecursoWww> root = cq.from(RecursoWww.class);
            
            cq.select(root).
                where(cb.and(
                    cb.equal(root.get(RecursoWww_.idSesion), idTema),
                    cb.equal(root.get(RecursoWww_.estado), 1)
                ));
            Query query = entityManager.createQuery(cq);
            
            List<RecursoWww> uds = query.getResultList();
            return uds;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void insertVideo(RecursoVideo video) {
        
        String sql = "INSERT INTO bd_wsgrv.recurso_video(id_sesion, result, text, url, referencia1, referencia2, estado, fecha_actualizado) "
		   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?) " ;  
        try {
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter(1, video.getIdSesion());
            query.setParameter(2, video.getResult());
            query.setParameter(3, video.getText());
            query.setParameter(4, video.getUrl());
            query.setParameter(5, "");
            query.setParameter(6, "");
            query.setParameter(7, 1);
            query.setParameter(8, util.getFechaActual());
            query.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;            
        }        
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void insertImagen(RecursoImg imagen) {
        
        String sql = "INSERT INTO bd_wsgrv.recurso_img(id_sesion, result, text, url, referencia1, referencia2, estado, fecha_actualizado) "
                   + " VALUES(?, ?, ?, ?, ?, ?, ?, ?) " ;        
        try { 
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter(1, imagen.getIdSesion());
            query.setParameter(2, imagen.getResult());
            query.setParameter(3, imagen.getText());
            query.setParameter(4, imagen.getUrl());
            query.setParameter(5, "");
            query.setParameter(6, "");
            query.setParameter(7, 1);
            query.setParameter(8, util.getFechaActual());
            query.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;            
        }          
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void insertWeb(RecursoWww web) {
        String sql = "INSERT INTO bd_wsgrv.recurso_www(id_sesion, result, text, url, referencia1, referencia2, estado, fecha_actualizado) "
                   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?) " ;  
        try {
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter(1, web.getIdSesion());
            query.setParameter(2, web.getResult());
            query.setParameter(3, web.getText());
            query.setParameter(4, web.getUrl());
            query.setParameter(5, "");
            query.setParameter(6, "");
            query.setParameter(7, 1);
            query.setParameter(8, util.getFechaActual());
            query.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;            
        }          
    }
    
}

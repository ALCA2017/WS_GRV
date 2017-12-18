package com.ws.grv.modelo.repository.impl;

import com.ws.grv.modelo.entidades.Marker;
import com.ws.grv.modelo.entidades.Marker_;
import com.ws.grv.modelo.repository.MarkerRepository;
import com.ws.grv.util.Utilitarios;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
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
public class MarkerRepositoryImpl implements MarkerRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(MarkerRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;    
    
    Utilitarios util = new Utilitarios();

    @Override
    public List<Marker> getMarkerByTemaId(int idTema) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<Marker> root = cq.from(Marker.class);
            
            cq.select(root).
                where(cb.and(
                    cb.equal(root.get(Marker_.idSesion), idTema),
                    cb.equal(root.get(Marker_.estado), 1)
                ));
            Query query = entityManager.createQuery(cq);
            
            List<Marker> uds = query.getResultList();
            return uds;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)    
    public void insertMarker(Marker marker) {
        
        String sql = "INSERT INTO bd_wsgrv.marker(id_sesion, nombre, img_patternmat, descripcion, estado, fecha_creado, fecha_actualizado) "
                   + " VALUES (?, ?, ?, ?, ?, ?, ?) " ;
        try { 
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter(1, marker.getIdSesion());
            query.setParameter(2, marker.getNombre());
            query.setParameter(3, marker.getImgPatternmat());
            query.setParameter(4, marker.getDescripcion());
            query.setParameter(5, 1);
            query.setParameter(6, util.getFechaActual());
            query.setParameter(7, util.getFechaActual());
            query.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;            
        }          
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)    
    public void insertMarker(Marker marker, String ruta) {
        
        String sql = "INSERT INTO bd_wsgrv.marker(id_sesion, nombre, img_patternmat, descripcion, estado, fecha_creado, fecha_actualizado) "
                   + " VALUES (?, ?, ?, ?, ?, ?, ?) " ;
        try { 
            //File file = new File(getCacheDirectory() + "\\results.txt");
            File file = new File("D:\\ruta\\nombreTema.jpg");
               
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter(1, marker.getIdSesion());
            query.setParameter(2, marker.getNombre());
            query.setParameter(3, Utilitarios.ImageToByte(file));
            query.setParameter(4, marker.getDescripcion());
            query.setParameter(5, 1);
            query.setParameter(6, util.getFechaActual());
            query.setParameter(7, util.getFechaActual());
            query.executeUpdate();
            
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            //throw e;            
        }          
    }   
    
}

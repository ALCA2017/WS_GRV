/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.repository.impl;

import com.ws.grv.dto.TemasUnidadDidacticaDTO;
import com.ws.grv.modelo.entidades.SesionUnidadDidactica;
import com.ws.grv.modelo.entidades.SesionUnidadDidactica_;
import com.ws.grv.modelo.entidades.UnidadDidactica;
import com.ws.grv.modelo.entidades.UnidadDidactica_;
import com.ws.grv.modelo.repository.SesionUnidadDidacticaRepository;
import com.ws.grv.modelo.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.tomcat.util.net.SSLHostConfigCertificate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SesionUnidadDidacticaRepositoryImpl implements SesionUnidadDidacticaRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(SesionUnidadDidacticaRepositoryImpl.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    
    
    /*
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
    }*/

    @Override
    public List<TemasUnidadDidacticaDTO> getTemas_Recursos_UD(int idUnidadDidactica) {
        String sql = "SELECT s.id_sesion, "
        + " s.sesion, s.titulo_sesion, d.indicadores , d.campo_tematico, "
        + " (SELECT count(*) FROM bd_wsgrv.recurso_img WHERE id_sesion = s.id_sesion) as nroIMG, "
        + " (SELECT count(*) FROM bd_wsgrv.recurso_video WHERE id_sesion = s.id_sesion) as nroVIDEO, "
        + " (SELECT count(*) FROM bd_wsgrv.recurso_www WHERE id_sesion = s.id_sesion) as nroWEB "
        + " FROM  bd_wsgrv.sesion_unidad_didactica s INNER JOIN bd_wsgrv.detalle_sesion d ON s.id_sesion = d.id_sesion "
        + " WHERE s.estado = 1 AND s.id_unidad_didactica = "+idUnidadDidactica;
        
        try {             
            Query query = entityManager.createNativeQuery(sql);            
            List<Object[]> resultList = query.getResultList();
                 
            List<TemasUnidadDidacticaDTO> lista_TemasUnidadDidacticaDTOs = new ArrayList<>(); 
            
            Iterator iter = resultList.iterator();

            for(Object[] ud: resultList){
               TemasUnidadDidacticaDTO t = new TemasUnidadDidacticaDTO();
                t.setId_sesion(Integer.parseInt(ud[0].toString()));
                //t.setId_curso_academico(null);
                t.setSesion((String)ud[1]);
                t.setTitulo_sesion((String)ud[2]);
                t.setIndicadores((String)ud[3]);
                t.setCampo_tematico((String)ud[4]);
                //t.setEstado(1);
                t.setNroIMG(Integer.parseInt(ud[5].toString()));
                t.setNroVIDEO(Integer.parseInt(ud[6].toString()));
                t.setNroWEB(Integer.parseInt(ud[7].toString()));
                
                lista_TemasUnidadDidacticaDTOs.add(t);
            }
            return lista_TemasUnidadDidacticaDTOs;            
                        
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;            
        } 
        
    }
    
}

package com.ws.grv.modelo.repository.impl;

import com.ws.grv.modelo.entidades.CursosAcademicos;
import com.ws.grv.modelo.entidades.NivGraDetalles;
import com.ws.grv.modelo.entidades.NivGraDetalles_;
import com.ws.grv.modelo.repository.NivGraDetallesRepository;
import com.ws.grv.modelo.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

        
@Repository
public class NivGraDetallesRepositoryImpl implements NivGraDetallesRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepository.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public NivGraDetalles buscar_x_id_niv_gra(int idNivGra) throws Exception {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<NivGraDetalles> root = cq.from(NivGraDetalles.class);
            
            cq.select(root).where(
                cb.equal(root.get(NivGraDetalles_.idNivGra), idNivGra)
            );
            
            Query q = entityManager.createQuery(cq);
            Object obj = null;
            try {
                obj = q.getSingleResult();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
            return obj != null ? (NivGraDetalles) obj : null;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<NivGraDetalles> listar_niv_gra_detalles_x_id(String idNivGra, int idArea) throws Exception {
        //List<String> lista = new ArrayList<>();
        try {
    // OPCION 1
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
        
            Root<NivGraDetalles> root = cq.from(NivGraDetalles.class);
            cq.select(root).
                where(
                    cb.and(
                        cb.equal(root.get(NivGraDetalles_.idNivGra), idNivGra),
                        cb.equal(root.get(NivGraDetalles_.idAreaAcademica), idArea)
                    )
            );
            cq.orderBy(cb.asc(root.get(NivGraDetalles_.nombreCortoCursoNgs)));
            Query query = entityManager.createQuery(cq);
    
    // OPCION 2
        //    List<NivGraDetalles> nds = q.getResultList();
        //    String jpql = "SELECT ngd FROM NivGraDetalles ngd WHERE ngd.idNivGra = '" + idNivGra + "' ";    
        //    Query query = entityManager.createQuery(jpql);
    
    // OPCION 3
        //    StringBuilder s = new StringBuilder();
        //    s.append("SELECT * FROM niv_gra_detalles ");
        //    s.append("INNER JOIN cursos_academicos CUR ON CUR.id_curso_academico=A.id_curso ");
        //    s.append("WHERE id_niv_gra=:'idNivGra' ");// AND id_area_academica=1");
        //    Query query = entityManager.createNativeQuery(s.toString());
        //    query.setParameter("idNivGra", idNivGra);
//            List<Object> eje = query.getResultList();
//            eje.stream().forEach((key) -> {
//                if (key != null){
//                    lista.add((String) key);
//                }
//            });
    // VALIDO para las Opciones 1 y 2
            List<NivGraDetalles> nds = query.getResultList();
            return nds;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<NivGraDetalles> listar_busqueda_x_idnivgra_idarea(String idNivGra, int idArea) throws Exception {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<NivGraDetalles> root = cq.from(NivGraDetalles.class);
            Join<NivGraDetalles, CursosAcademicos> join = root.join(NivGraDetalles_.idCurso, JoinType.INNER);
            cq.select(root).
                distinct(true).
                    where(
                        cb.and(
                            cb.equal(root.get(NivGraDetalles_.idNivGra), idNivGra)
                            //cb.equal(join.get(NivGraDetalles_.idCurso).get(CursosAcademicos_.idAreaAcademica), idArea)
                        )
                    );
            
            Query q = entityManager.createQuery(cq);
            
            List<NivGraDetalles> nds = q.getResultList();
            return nds;            
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }
    
}

package com.ws.grv.wsgrv;

import com.ws.grv.WsgrvApplication;
import com.ws.grv.modelo.entidades.CursosAcademicos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.springframework.boot.SpringApplication;

public class PruebaEntidades {

    public static void main(String[] args) {
        SpringApplication.run(WsgrvApplication.class, args);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cursos_x_Area");
        EntityManager em = emf.createEntityManager();
        TypedQuery<CursosAcademicos> consultaCursos = em.createNamedQuery("Selecciona_Cursos_Areas", CursosAcademicos.class);
        consultaCursos.setParameter("id_area_academica", 1);
        List<CursosAcademicos> lista = consultaCursos.getResultList();
        
        System.out.println("-------------------- CURSOS --------------------");
        for (CursosAcademicos a : lista) {
            System.out.println("Curso: " + a.getNombreCurso() + " | " + a.getNombreCortoCurso() + " | Area: " + a.getIdAreaAcademica().getNombreArea());
        }
        em.close();
        System.out.println("-------------------- Terminó --------------------");
            
    }    
    
//    public List<CursosAcademicos> resultados(){
//        EntityManager em;
        //List<CursosAcademicos> results = em.createNamedQuery()
//    }
        
}
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.entidades;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vacpc
 */
@Entity
@Table(schema = "bd_wsgrv", name = "cursos_academicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursosAcademicos.findAll", query = "SELECT c FROM CursosAcademicos c"),
    @NamedQuery(name = "CursosAcademicos.findByIdCursoAcademico", query = "SELECT c FROM CursosAcademicos c WHERE c.idCursoAcademico = :idCursoAcademico"),
    @NamedQuery(name = "CursosAcademicos.findByNombreCortoCurso", query = "SELECT c FROM CursosAcademicos c WHERE c.nombreCortoCurso = :nombreCortoCurso"),
    @NamedQuery(name = "CursosAcademicos.findByNombreCurso", query = "SELECT c FROM CursosAcademicos c WHERE c.nombreCurso = :nombreCurso")})
public class CursosAcademicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_curso_academico")
    private Integer idCursoAcademico;
    @Size(max = 4)
    @Column(name = "nombre_corto_curso")
    private String nombreCortoCurso;
    @Size(max = 50)
    @Column(name = "nombre_curso")
    private String nombreCurso;
    @JoinColumn(name = "id_area_academica", referencedColumnName = "id_area_academica")
    @ManyToOne(fetch = FetchType.LAZY)
    private AreasAcademicas idAreaAcademica;
    @OneToMany(mappedBy = "idCurso", fetch = FetchType.LAZY)
    private Set<NivGraDetalles> nivGraDetallesSet;

    public CursosAcademicos() {
    }

    public CursosAcademicos(Integer idCursoAcademico) {
        this.idCursoAcademico = idCursoAcademico;
    }

    public Integer getIdCursoAcademico() {
        return idCursoAcademico;
    }

    public void setIdCursoAcademico(Integer idCursoAcademico) {
        this.idCursoAcademico = idCursoAcademico;
    }

    public String getNombreCortoCurso() {
        return nombreCortoCurso;
    }

    public void setNombreCortoCurso(String nombreCortoCurso) {
        this.nombreCortoCurso = nombreCortoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public AreasAcademicas getIdAreaAcademica() {
        return idAreaAcademica;
    }

    public void setIdAreaAcademica(AreasAcademicas idAreaAcademica) {
        this.idAreaAcademica = idAreaAcademica;
    }

    @XmlTransient
    public Set<NivGraDetalles> getNivGraDetallesSet() {
        return nivGraDetallesSet;
    }

    public void setNivGraDetallesSet(Set<NivGraDetalles> nivGraDetallesSet) {
        this.nivGraDetallesSet = nivGraDetallesSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCursoAcademico != null ? idCursoAcademico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursosAcademicos)) {
            return false;
        }
        CursosAcademicos other = (CursosAcademicos) object;
        if ((this.idCursoAcademico == null && other.idCursoAcademico != null) || (this.idCursoAcademico != null && !this.idCursoAcademico.equals(other.idCursoAcademico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ws.grv.modelo.entidades.CursosAcademicos[ idCursoAcademico=" + idCursoAcademico + " ]";
    }
    
}

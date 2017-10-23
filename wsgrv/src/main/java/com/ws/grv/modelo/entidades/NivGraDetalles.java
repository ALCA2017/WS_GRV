/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vacpc
 */
@Entity
@Table(schema = "bd_wsgrv", name = "niv_gra_detalles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivGraDetalles.findAll", query = "SELECT n FROM NivGraDetalles n"),
    @NamedQuery(name = "NivGraDetalles.findByIdNivGraDetalles", query = "SELECT n FROM NivGraDetalles n WHERE n.idNivGraDetalles = :idNivGraDetalles"),
    @NamedQuery(name = "NivGraDetalles.findByNombreCortoCursoNgs", query = "SELECT n FROM NivGraDetalles n WHERE n.nombreCortoCursoNgs = :nombreCortoCursoNgs"),
    @NamedQuery(name = "NivGraDetalles.findByOrdenEras", query = "SELECT n FROM NivGraDetalles n WHERE n.ordenEras = :ordenEras"),
    @NamedQuery(name = "NivGraDetalles.findByIdDocenteResponsable", query = "SELECT n FROM NivGraDetalles n WHERE n.idDocenteResponsable = :idDocenteResponsable"),
    @NamedQuery(name = "NivGraDetalles.findByIdNivGra", query = "SELECT n FROM NivGraDetalles n WHERE n.idNivGra = :idNivGra"),
    @NamedQuery(name = "NivGraDetalles.findByIdAreaAcademica", query = "SELECT n FROM NivGraDetalles n WHERE n.idAreaAcademica = :idAreaAcademica")})
public class NivGraDetalles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_niv_gra_detalles")
    private Integer idNivGraDetalles;
    @Size(max = 7)
    @Column(name = "nombre_corto_curso_ngs")
    private String nombreCortoCursoNgs;
    @Column(name = "orden_eras")
    private Integer ordenEras;
    @Column(name = "id_docente_responsable")
    private Integer idDocenteResponsable;
    @Size(max = 2)
    @Column(name = "id_niv_gra")
    private String idNivGra;
    @Column(name = "id_area_academica")
    private Integer idAreaAcademica;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso_academico")
    @ManyToOne(fetch = FetchType.LAZY)
    private CursosAcademicos idCurso;

    public NivGraDetalles() {
    }

    public NivGraDetalles(Integer idNivGraDetalles) {
        this.idNivGraDetalles = idNivGraDetalles;
    }

    public Integer getIdNivGraDetalles() {
        return idNivGraDetalles;
    }

    public void setIdNivGraDetalles(Integer idNivGraDetalles) {
        this.idNivGraDetalles = idNivGraDetalles;
    }

    public String getNombreCortoCursoNgs() {
        return nombreCortoCursoNgs;
    }

    public void setNombreCortoCursoNgs(String nombreCortoCursoNgs) {
        this.nombreCortoCursoNgs = nombreCortoCursoNgs;
    }

    public Integer getOrdenEras() {
        return ordenEras;
    }

    public void setOrdenEras(Integer ordenEras) {
        this.ordenEras = ordenEras;
    }

    public Integer getIdDocenteResponsable() {
        return idDocenteResponsable;
    }

    public void setIdDocenteResponsable(Integer idDocenteResponsable) {
        this.idDocenteResponsable = idDocenteResponsable;
    }

    public String getIdNivGra() {
        return idNivGra;
    }

    public void setIdNivGra(String idNivGra) {
        this.idNivGra = idNivGra;
    }

    public Integer getIdAreaAcademica() {
        return idAreaAcademica;
    }

    public void setIdAreaAcademica(Integer idAreaAcademica) {
        this.idAreaAcademica = idAreaAcademica;
    }

    public CursosAcademicos getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(CursosAcademicos idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivGraDetalles != null ? idNivGraDetalles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivGraDetalles)) {
            return false;
        }
        NivGraDetalles other = (NivGraDetalles) object;
        if ((this.idNivGraDetalles == null && other.idNivGraDetalles != null) || (this.idNivGraDetalles != null && !this.idNivGraDetalles.equals(other.idNivGraDetalles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ws.grv.modelo.entidades.NivGraDetalles[ idNivGraDetalles=" + idNivGraDetalles + " ]";
    }
    
}

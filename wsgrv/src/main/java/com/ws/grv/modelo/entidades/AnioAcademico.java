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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vacpc
 */
@Entity
@Table(schema = "bd_wsgrv", name = "anio_academico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnioAcademico.findAll", query = "SELECT a FROM AnioAcademico a"),
    @NamedQuery(name = "AnioAcademico.findByIdAnioAcademico", query = "SELECT a FROM AnioAcademico a WHERE a.idAnioAcademico = :idAnioAcademico"),
    @NamedQuery(name = "AnioAcademico.findByAnio", query = "SELECT a FROM AnioAcademico a WHERE a.anio = :anio"),
    @NamedQuery(name = "AnioAcademico.findByDescripcion", query = "SELECT a FROM AnioAcademico a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "AnioAcademico.findByEstado", query = "SELECT a FROM AnioAcademico a WHERE a.estado = :estado")})
public class AnioAcademico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anio_academico")
    private Integer idAnioAcademico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio")
    private int anio;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @OneToMany(mappedBy = "idAnioAcademico", fetch = FetchType.LAZY)
    private Set<UnidadDidactica> unidadDidacticaSet;

    public AnioAcademico() {
    }

    public AnioAcademico(Integer idAnioAcademico) {
        this.idAnioAcademico = idAnioAcademico;
    }

    public AnioAcademico(Integer idAnioAcademico, int anio, int estado) {
        this.idAnioAcademico = idAnioAcademico;
        this.anio = anio;
        this.estado = estado;
    }

    public Integer getIdAnioAcademico() {
        return idAnioAcademico;
    }

    public void setIdAnioAcademico(Integer idAnioAcademico) {
        this.idAnioAcademico = idAnioAcademico;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Set<UnidadDidactica> getUnidadDidacticaSet() {
        return unidadDidacticaSet;
    }

    public void setUnidadDidacticaSet(Set<UnidadDidactica> unidadDidacticaSet) {
        this.unidadDidacticaSet = unidadDidacticaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnioAcademico != null ? idAnioAcademico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnioAcademico)) {
            return false;
        }
        AnioAcademico other = (AnioAcademico) object;
        if ((this.idAnioAcademico == null && other.idAnioAcademico != null) || (this.idAnioAcademico != null && !this.idAnioAcademico.equals(other.idAnioAcademico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ws.grv.modelo.entidades.AnioAcademico[ idAnioAcademico=" + idAnioAcademico + " ]";
    }
    
}

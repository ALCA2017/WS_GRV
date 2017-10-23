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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vacpc
 */
@Entity
@Table(schema = "bd_wsgrv", name = "niv_gra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivGra.findAll", query = "SELECT n FROM NivGra n"),
    @NamedQuery(name = "NivGra.findByIdNivGra", query = "SELECT n FROM NivGra n WHERE n.idNivGra = :idNivGra"),
    @NamedQuery(name = "NivGra.findByDescripcionNivGra", query = "SELECT n FROM NivGra n WHERE n.descripcionNivGra = :descripcionNivGra")})
public class NivGra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 2)
    @Column(name = "id_niv_gra")
    private String idNivGra;
    @Size(max = 30)
    @Column(name = "descripcion_niv_gra")
    private String descripcionNivGra;
    @OneToMany(mappedBy = "idNivGra", fetch = FetchType.LAZY)
    private Set<NivGraDetalles> nivGraDetallesSet;
    @OneToMany(mappedBy = "idNivGra", fetch = FetchType.LAZY)
    private Set<NivGraMatriculados> nivGraMatriculadosSet;

    public NivGra() {
    }

    public NivGra(String idNivGra) {
        this.idNivGra = idNivGra;
    }

    public String getIdNivGra() {
        return idNivGra;
    }

    public void setIdNivGra(String idNivGra) {
        this.idNivGra = idNivGra;
    }

    public String getDescripcionNivGra() {
        return descripcionNivGra;
    }

    public void setDescripcionNivGra(String descripcionNivGra) {
        this.descripcionNivGra = descripcionNivGra;
    }

    @XmlTransient
    public Set<NivGraDetalles> getNivGraDetallesSet() {
        return nivGraDetallesSet;
    }

    public void setNivGraDetallesSet(Set<NivGraDetalles> nivGraDetallesSet) {
        this.nivGraDetallesSet = nivGraDetallesSet;
    }

    @XmlTransient
    public Set<NivGraMatriculados> getNivGraMatriculadosSet() {
        return nivGraMatriculadosSet;
    }

    public void setNivGraMatriculadosSet(Set<NivGraMatriculados> nivGraMatriculadosSet) {
        this.nivGraMatriculadosSet = nivGraMatriculadosSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivGra != null ? idNivGra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivGra)) {
            return false;
        }
        NivGra other = (NivGra) object;
        if ((this.idNivGra == null && other.idNivGra != null) || (this.idNivGra != null && !this.idNivGra.equals(other.idNivGra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ws.grv.modelo.entidades.NivGra[ idNivGra=" + idNivGra + " ]";
    }
    
}

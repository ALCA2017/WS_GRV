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
@Table(schema = "bd_wsgrv", name = "grado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grado.findAll", query = "SELECT g FROM Grado g"),
    @NamedQuery(name = "Grado.findByIdGrado", query = "SELECT g FROM Grado g WHERE g.idGrado = :idGrado"),
    @NamedQuery(name = "Grado.findByGrado", query = "SELECT g FROM Grado g WHERE g.grado = :grado"),
    @NamedQuery(name = "Grado.findByGradoNombreCorto", query = "SELECT g FROM Grado g WHERE g.gradoNombreCorto = :gradoNombreCorto")})
public class Grado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grado")
    private Integer idGrado;
    @Size(max = 30)
    @Column(name = "grado")
    private String grado;
    @Size(max = 2)
    @Column(name = "grado_nombre_corto")
    private String gradoNombreCorto;
    @OneToMany(mappedBy = "idGrado", fetch = FetchType.LAZY)
    private Set<NivGraMatriculados> nivGraMatriculadosSet;

    public Grado() {
    }

    public Grado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getGradoNombreCorto() {
        return gradoNombreCorto;
    }

    public void setGradoNombreCorto(String gradoNombreCorto) {
        this.gradoNombreCorto = gradoNombreCorto;
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
        hash += (idGrado != null ? idGrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grado)) {
            return false;
        }
        Grado other = (Grado) object;
        if ((this.idGrado == null && other.idGrado != null) || (this.idGrado != null && !this.idGrado.equals(other.idGrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ws.grv.modelo.entidades.Grado[ idGrado=" + idGrado + " ]";
    }
    
}

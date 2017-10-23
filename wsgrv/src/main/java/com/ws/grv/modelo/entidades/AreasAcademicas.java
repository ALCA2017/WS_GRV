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
@Table(schema = "bd_wsgrv", name = "areas_academicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreasAcademicas.findAll", query = "SELECT a FROM AreasAcademicas a"),
    @NamedQuery(name = "AreasAcademicas.findByIdAreaAcademica", query = "SELECT a FROM AreasAcademicas a WHERE a.idAreaAcademica = :idAreaAcademica"),
    @NamedQuery(name = "AreasAcademicas.findByNombreArea", query = "SELECT a FROM AreasAcademicas a WHERE a.nombreArea = :nombreArea"),
    @NamedQuery(name = "AreasAcademicas.findByNombreCortoArea", query = "SELECT a FROM AreasAcademicas a WHERE a.nombreCortoArea = :nombreCortoArea")})
public class AreasAcademicas implements Serializable {

    @OneToMany(mappedBy = "idAreaAcademica", fetch = FetchType.LAZY)
    private Set<UnidadDidactica> unidadDidacticaSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_area_academica")
    private Integer idAreaAcademica;
    @Size(max = 30)
    @Column(name = "nombre_area")
    private String nombreArea;
    @Size(max = 4)
    @Column(name = "nombre_corto_area")
    private String nombreCortoArea;
    @OneToMany(mappedBy = "idAreaAcademica", fetch = FetchType.LAZY)
    private Set<CursosAcademicos> cursosAcademicosSet;

    public AreasAcademicas() {
    }

    public AreasAcademicas(Integer idAreaAcademica) {
        this.idAreaAcademica = idAreaAcademica;
    }

    public Integer getIdAreaAcademica() {
        return idAreaAcademica;
    }

    public void setIdAreaAcademica(Integer idAreaAcademica) {
        this.idAreaAcademica = idAreaAcademica;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getNombreCortoArea() {
        return nombreCortoArea;
    }

    public void setNombreCortoArea(String nombreCortoArea) {
        this.nombreCortoArea = nombreCortoArea;
    }

    @XmlTransient
    public Set<CursosAcademicos> getCursosAcademicosSet() {
        return cursosAcademicosSet;
    }

    public void setCursosAcademicosSet(Set<CursosAcademicos> cursosAcademicosSet) {
        this.cursosAcademicosSet = cursosAcademicosSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAreaAcademica != null ? idAreaAcademica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreasAcademicas)) {
            return false;
        }
        AreasAcademicas other = (AreasAcademicas) object;
        if ((this.idAreaAcademica == null && other.idAreaAcademica != null) || (this.idAreaAcademica != null && !this.idAreaAcademica.equals(other.idAreaAcademica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ws.grv.modelo.entidades.AreasAcademicas[ idAreaAcademica=" + idAreaAcademica + " ]";
    }

    @XmlTransient
    public Set<UnidadDidactica> getUnidadDidacticaSet() {
        return unidadDidacticaSet;
    }

    public void setUnidadDidacticaSet(Set<UnidadDidactica> unidadDidacticaSet) {
        this.unidadDidacticaSet = unidadDidacticaSet;
    }
    
}

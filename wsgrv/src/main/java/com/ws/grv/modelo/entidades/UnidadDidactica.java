/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vacpc
 */
@Entity
@Table(schema = "bd_wsgrv", name = "unidad_didactica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadDidactica.findAll", query = "SELECT u FROM UnidadDidactica u"),
    @NamedQuery(name = "UnidadDidactica.findByIdUnidadDidactica", query = "SELECT u FROM UnidadDidactica u WHERE u.idUnidadDidactica = :idUnidadDidactica"),
    @NamedQuery(name = "UnidadDidactica.findByNroUnidad", query = "SELECT u FROM UnidadDidactica u WHERE u.nroUnidad = :nroUnidad"),
    @NamedQuery(name = "UnidadDidactica.findByTituloUnidad", query = "SELECT u FROM UnidadDidactica u WHERE u.tituloUnidad = :tituloUnidad"),
    @NamedQuery(name = "UnidadDidactica.findByEstado", query = "SELECT u FROM UnidadDidactica u WHERE u.estado = :estado"),
    @NamedQuery(name = "UnidadDidactica.findByFechaActualizado", query = "SELECT u FROM UnidadDidactica u WHERE u.fechaActualizado = :fechaActualizado")})
public class UnidadDidactica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unidad_didactica")
    private Integer idUnidadDidactica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_unidad")
    private int nroUnidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo_unidad")
    private String tituloUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Column(name = "fecha_actualizado")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizado;
    @JoinColumn(name = "id_anio_academico", referencedColumnName = "id_anio_academico")
    @ManyToOne(fetch = FetchType.LAZY)
    private AnioAcademico idAnioAcademico;
    @JoinColumn(name = "id_area_academica", referencedColumnName = "id_area_academica")
    @ManyToOne(fetch = FetchType.LAZY)
    private AreasAcademicas idAreaAcademica;
    @OneToMany(mappedBy = "idUnidadDidactica", fetch = FetchType.LAZY)
    private Set<SesionUnidadDidactica> sesionUnidadDidacticaSet;

    public UnidadDidactica() {
    }

    public UnidadDidactica(Integer idUnidadDidactica) {
        this.idUnidadDidactica = idUnidadDidactica;
    }

    public UnidadDidactica(Integer idUnidadDidactica, int nroUnidad, String tituloUnidad, int estado) {
        this.idUnidadDidactica = idUnidadDidactica;
        this.nroUnidad = nroUnidad;
        this.tituloUnidad = tituloUnidad;
        this.estado = estado;
    }

    public Integer getIdUnidadDidactica() {
        return idUnidadDidactica;
    }

    public void setIdUnidadDidactica(Integer idUnidadDidactica) {
        this.idUnidadDidactica = idUnidadDidactica;
    }

    public int getNroUnidad() {
        return nroUnidad;
    }

    public void setNroUnidad(int nroUnidad) {
        this.nroUnidad = nroUnidad;
    }

    public String getTituloUnidad() {
        return tituloUnidad;
    }

    public void setTituloUnidad(String tituloUnidad) {
        this.tituloUnidad = tituloUnidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechaActualizado() {
        return fechaActualizado;
    }

    public void setFechaActualizado(Date fechaActualizado) {
        this.fechaActualizado = fechaActualizado;
    }

    public AnioAcademico getIdAnioAcademico() {
        return idAnioAcademico;
    }

    public void setIdAnioAcademico(AnioAcademico idAnioAcademico) {
        this.idAnioAcademico = idAnioAcademico;
    }

    public AreasAcademicas getIdAreaAcademica() {
        return idAreaAcademica;
    }

    public void setIdAreaAcademica(AreasAcademicas idAreaAcademica) {
        this.idAreaAcademica = idAreaAcademica;
    }

    @XmlTransient
    public Set<SesionUnidadDidactica> getSesionUnidadDidacticaSet() {
        return sesionUnidadDidacticaSet;
    }

    public void setSesionUnidadDidacticaSet(Set<SesionUnidadDidactica> sesionUnidadDidacticaSet) {
        this.sesionUnidadDidacticaSet = sesionUnidadDidacticaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadDidactica != null ? idUnidadDidactica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadDidactica)) {
            return false;
        }
        UnidadDidactica other = (UnidadDidactica) object;
        if ((this.idUnidadDidactica == null && other.idUnidadDidactica != null) || (this.idUnidadDidactica != null && !this.idUnidadDidactica.equals(other.idUnidadDidactica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ws.grv.modelo.entidades.UnidadDidactica[ idUnidadDidactica=" + idUnidadDidactica + " ]";
    }
    
}

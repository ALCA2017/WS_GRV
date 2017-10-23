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
@Table(schema = "bd_wsgrv", name = "sesion_unidad_didactica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SesionUnidadDidactica.findAll", query = "SELECT s FROM SesionUnidadDidactica s"),
    @NamedQuery(name = "SesionUnidadDidactica.findByIdSesion", query = "SELECT s FROM SesionUnidadDidactica s WHERE s.idSesion = :idSesion"),
    @NamedQuery(name = "SesionUnidadDidactica.findByIdCursoAcademico", query = "SELECT s FROM SesionUnidadDidactica s WHERE s.idCursoAcademico = :idCursoAcademico"),
    @NamedQuery(name = "SesionUnidadDidactica.findBySesion", query = "SELECT s FROM SesionUnidadDidactica s WHERE s.sesion = :sesion"),
    @NamedQuery(name = "SesionUnidadDidactica.findByTituloSesion", query = "SELECT s FROM SesionUnidadDidactica s WHERE s.tituloSesion = :tituloSesion"),
    @NamedQuery(name = "SesionUnidadDidactica.findByEstado", query = "SELECT s FROM SesionUnidadDidactica s WHERE s.estado = :estado"),
    @NamedQuery(name = "SesionUnidadDidactica.findByFechaActualizado", query = "SELECT s FROM SesionUnidadDidactica s WHERE s.fechaActualizado = :fechaActualizado")})
public class SesionUnidadDidactica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sesion")
    private Integer idSesion;
    @Column(name = "id_curso_academico")
    private Integer idCursoAcademico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sesion")
    private String sesion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "titulo_sesion")
    private String tituloSesion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Column(name = "fecha_actualizado")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizado;
    @OneToMany(mappedBy = "idSesion", fetch = FetchType.LAZY)
    private Set<DetalleSesion> detalleSesionSet;
    @OneToMany(mappedBy = "idSesion", fetch = FetchType.LAZY)
    private Set<ActividadesSesion> actividadesSesionSet;
    @JoinColumn(name = "id_unidad_didactica", referencedColumnName = "id_unidad_didactica")
    @ManyToOne(fetch = FetchType.LAZY)
    private UnidadDidactica idUnidadDidactica;

    public SesionUnidadDidactica() {
    }

    public SesionUnidadDidactica(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public SesionUnidadDidactica(Integer idSesion, String sesion, String tituloSesion, int estado) {
        this.idSesion = idSesion;
        this.sesion = sesion;
        this.tituloSesion = tituloSesion;
        this.estado = estado;
    }

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public Integer getIdCursoAcademico() {
        return idCursoAcademico;
    }

    public void setIdCursoAcademico(Integer idCursoAcademico) {
        this.idCursoAcademico = idCursoAcademico;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public String getTituloSesion() {
        return tituloSesion;
    }

    public void setTituloSesion(String tituloSesion) {
        this.tituloSesion = tituloSesion;
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

    @XmlTransient
    public Set<DetalleSesion> getDetalleSesionSet() {
        return detalleSesionSet;
    }

    public void setDetalleSesionSet(Set<DetalleSesion> detalleSesionSet) {
        this.detalleSesionSet = detalleSesionSet;
    }

    @XmlTransient
    public Set<ActividadesSesion> getActividadesSesionSet() {
        return actividadesSesionSet;
    }

    public void setActividadesSesionSet(Set<ActividadesSesion> actividadesSesionSet) {
        this.actividadesSesionSet = actividadesSesionSet;
    }

    public UnidadDidactica getIdUnidadDidactica() {
        return idUnidadDidactica;
    }

    public void setIdUnidadDidactica(UnidadDidactica idUnidadDidactica) {
        this.idUnidadDidactica = idUnidadDidactica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSesion != null ? idSesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SesionUnidadDidactica)) {
            return false;
        }
        SesionUnidadDidactica other = (SesionUnidadDidactica) object;
        if ((this.idSesion == null && other.idSesion != null) || (this.idSesion != null && !this.idSesion.equals(other.idSesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ws.grv.modelo.entidades.SesionUnidadDidactica[ idSesion=" + idSesion + " ]";
    }
    
}

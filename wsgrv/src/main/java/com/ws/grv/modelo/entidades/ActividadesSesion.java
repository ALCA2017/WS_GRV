/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vacpc
 */
@Entity
@Table(schema = "bd_wsgrv", name = "actividades_sesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadesSesion.findAll", query = "SELECT a FROM ActividadesSesion a"),
    @NamedQuery(name = "ActividadesSesion.findByIdActividades", query = "SELECT a FROM ActividadesSesion a WHERE a.idActividades = :idActividades"),
    @NamedQuery(name = "ActividadesSesion.findByDescripcion", query = "SELECT a FROM ActividadesSesion a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "ActividadesSesion.findByEstado", query = "SELECT a FROM ActividadesSesion a WHERE a.estado = :estado"),
    @NamedQuery(name = "ActividadesSesion.findByFechaActualizado", query = "SELECT a FROM ActividadesSesion a WHERE a.fechaActualizado = :fechaActualizado")})
public class ActividadesSesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actividades")
    private Integer idActividades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Column(name = "fecha_actualizado")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizado;
    @JoinColumn(name = "id_sesion", referencedColumnName = "id_sesion")
    @ManyToOne(fetch = FetchType.LAZY)
    private SesionUnidadDidactica idSesion;

    public ActividadesSesion() {
    }

    public ActividadesSesion(Integer idActividades) {
        this.idActividades = idActividades;
    }

    public ActividadesSesion(Integer idActividades, String descripcion, int estado) {
        this.idActividades = idActividades;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdActividades() {
        return idActividades;
    }

    public void setIdActividades(Integer idActividades) {
        this.idActividades = idActividades;
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

    public Date getFechaActualizado() {
        return fechaActualizado;
    }

    public void setFechaActualizado(Date fechaActualizado) {
        this.fechaActualizado = fechaActualizado;
    }

    public SesionUnidadDidactica getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(SesionUnidadDidactica idSesion) {
        this.idSesion = idSesion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividades != null ? idActividades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadesSesion)) {
            return false;
        }
        ActividadesSesion other = (ActividadesSesion) object;
        if ((this.idActividades == null && other.idActividades != null) || (this.idActividades != null && !this.idActividades.equals(other.idActividades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ws.grv.modelo.entidades.ActividadesSesion[ idActividades=" + idActividades + " ]";
    }
    
}

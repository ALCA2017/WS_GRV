/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.grv;

import com.ws.grv.modelo.entidades.SesionUnidadDidactica;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALI
 */
@MappedSuperclass
@Table(name = "indicadores_sesion")
@XmlRootElement
public class IndicadoresSesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_indicadores")
    private Integer idIndicadores;
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
    @ManyToOne
    private SesionUnidadDidactica idSesion;

    public IndicadoresSesion() {
    }

    public IndicadoresSesion(Integer idIndicadores) {
        this.idIndicadores = idIndicadores;
    }

    public IndicadoresSesion(Integer idIndicadores, String descripcion, int estado) {
        this.idIndicadores = idIndicadores;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdIndicadores() {
        return idIndicadores;
    }

    public void setIdIndicadores(Integer idIndicadores) {
        this.idIndicadores = idIndicadores;
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
        hash += (idIndicadores != null ? idIndicadores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndicadoresSesion)) {
            return false;
        }
        IndicadoresSesion other = (IndicadoresSesion) object;
        if ((this.idIndicadores == null && other.idIndicadores != null) || (this.idIndicadores != null && !this.idIndicadores.equals(other.idIndicadores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ws.grv.IndicadoresSesion[ idIndicadores=" + idIndicadores + " ]";
    }
    
}

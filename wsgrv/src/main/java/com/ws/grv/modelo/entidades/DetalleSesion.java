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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vacpc
 */
@Entity
@Table(schema = "bd_wsgrv", name = "detalle_sesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleSesion.findAll", query = "SELECT d FROM DetalleSesion d"),
    @NamedQuery(name = "DetalleSesion.findByIdDetalleSesion", query = "SELECT d FROM DetalleSesion d WHERE d.idDetalleSesion = :idDetalleSesion"),
    @NamedQuery(name = "DetalleSesion.findByIndicadores", query = "SELECT d FROM DetalleSesion d WHERE d.indicadores = :indicadores"),
    @NamedQuery(name = "DetalleSesion.findByCampoTematico", query = "SELECT d FROM DetalleSesion d WHERE d.campoTematico = :campoTematico")})
public class DetalleSesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_sesion")
    private Integer idDetalleSesion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2500)
    @Column(name = "indicadores")
    private String indicadores;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2500)
    @Column(name = "campo_tematico")
    private String campoTematico;
    @JoinColumn(name = "id_sesion", referencedColumnName = "id_sesion")
    @ManyToOne(fetch = FetchType.LAZY)
    private SesionUnidadDidactica idSesion;

    public DetalleSesion() {
    }

    public DetalleSesion(Integer idDetalleSesion) {
        this.idDetalleSesion = idDetalleSesion;
    }

    public DetalleSesion(Integer idDetalleSesion, String indicadores, String campoTematico) {
        this.idDetalleSesion = idDetalleSesion;
        this.indicadores = indicadores;
        this.campoTematico = campoTematico;
    }

    public Integer getIdDetalleSesion() {
        return idDetalleSesion;
    }

    public void setIdDetalleSesion(Integer idDetalleSesion) {
        this.idDetalleSesion = idDetalleSesion;
    }

    public String getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(String indicadores) {
        this.indicadores = indicadores;
    }

    public String getCampoTematico() {
        return campoTematico;
    }

    public void setCampoTematico(String campoTematico) {
        this.campoTematico = campoTematico;
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
        hash += (idDetalleSesion != null ? idDetalleSesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleSesion)) {
            return false;
        }
        DetalleSesion other = (DetalleSesion) object;
        if ((this.idDetalleSesion == null && other.idDetalleSesion != null) || (this.idDetalleSesion != null && !this.idDetalleSesion.equals(other.idDetalleSesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ws.grv.modelo.entidades.DetalleSesion[ idDetalleSesion=" + idDetalleSesion + " ]";
    }
    
}

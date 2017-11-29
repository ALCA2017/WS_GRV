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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(schema = "bd_wsgrv", name = "marker")
@XmlRootElement
public class Marker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_marker")
    private Integer idMarker;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "img_patternmat")
    private byte[] imgPatternmat;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Column(name = "fecha_creado")
    @Temporal(TemporalType.DATE)
    private Date fechaCreado;
    @Column(name = "fecha_actualizado")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizado;
    @JoinColumn(name = "id_sesion", referencedColumnName = "id_sesion")
    @ManyToOne
    private SesionUnidadDidactica idSesion;

    public Marker() {
    }

    public Marker(SesionUnidadDidactica id_sesion, String nombre, 
                    byte[] img_patternMat, String descripcion) {
            this.idSesion 	= id_sesion;
            this.nombre 	= nombre;
            this.imgPatternmat 	= img_patternMat;
            this.descripcion 	= descripcion;
    }	    
    public Marker(Integer idMarker) {
        this.idMarker = idMarker;
    }

    public Marker(Integer idMarker, String nombre, byte[] imgPatternmat, int estado) {
        this.idMarker = idMarker;
        this.nombre = nombre;
        this.imgPatternmat = imgPatternmat;
        this.estado = estado;
    }

    public Integer getIdMarker() {
        return idMarker;
    }

    public void setIdMarker(Integer idMarker) {
        this.idMarker = idMarker;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getImgPatternmat() {
        return imgPatternmat;
    }

    public void setImgPatternmat(byte[] imgPatternmat) {
        this.imgPatternmat = imgPatternmat;
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

    public Date getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
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
        hash += (idMarker != null ? idMarker.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marker)) {
            return false;
        }
        Marker other = (Marker) object;
        if ((this.idMarker == null && other.idMarker != null) || (this.idMarker != null && !this.idMarker.equals(other.idMarker))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idMarker.toString();
    }
    
}

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
@Table(schema = "bd_wsgrv", name = "usuarios_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosDetalle.findAll", query = "SELECT u FROM UsuariosDetalle u"),
    @NamedQuery(name = "UsuariosDetalle.findByIdUsuarioDetalles", query = "SELECT u FROM UsuariosDetalle u WHERE u.idUsuarioDetalles = :idUsuarioDetalles"),
    @NamedQuery(name = "UsuariosDetalle.findByNombres", query = "SELECT u FROM UsuariosDetalle u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "UsuariosDetalle.findByApellidoPaterno", query = "SELECT u FROM UsuariosDetalle u WHERE u.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "UsuariosDetalle.findByApellidoMaterno", query = "SELECT u FROM UsuariosDetalle u WHERE u.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "UsuariosDetalle.findBySexo", query = "SELECT u FROM UsuariosDetalle u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "UsuariosDetalle.findByTelefonoFijo", query = "SELECT u FROM UsuariosDetalle u WHERE u.telefonoFijo = :telefonoFijo"),
    @NamedQuery(name = "UsuariosDetalle.findByTelefonoMovil", query = "SELECT u FROM UsuariosDetalle u WHERE u.telefonoMovil = :telefonoMovil")})
public class UsuariosDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_detalles")
    private Integer idUsuarioDetalles;
    @Size(max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 30)
    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;
    @Size(max = 30)
    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 7)
    @Column(name = "telefonoFijo")
    private String telefonoFijo;
    @Size(max = 9)
    @Column(name = "telefonoMovil")
    private String telefonoMovil;
    @OneToMany(mappedBy = "idUsuarioDetalles", fetch = FetchType.LAZY)
    private Set<Usuarios> usuariosSet;

    public UsuariosDetalle() {
    }

    public UsuariosDetalle(Integer idUsuarioDetalles) {
        this.idUsuarioDetalles = idUsuarioDetalles;
    }

    public Integer getIdUsuarioDetalles() {
        return idUsuarioDetalles;
    }

    public void setIdUsuarioDetalles(Integer idUsuarioDetalles) {
        this.idUsuarioDetalles = idUsuarioDetalles;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    @XmlTransient
    public Set<Usuarios> getUsuariosSet() {
        return usuariosSet;
    }

    public void setUsuariosSet(Set<Usuarios> usuariosSet) {
        this.usuariosSet = usuariosSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioDetalles != null ? idUsuarioDetalles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosDetalle)) {
            return false;
        }
        UsuariosDetalle other = (UsuariosDetalle) object;
        if ((this.idUsuarioDetalles == null && other.idUsuarioDetalles != null) || (this.idUsuarioDetalles != null && !this.idUsuarioDetalles.equals(other.idUsuarioDetalles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ws.grv.modelo.entidades.UsuariosDetalle[ idUsuarioDetalles=" + idUsuarioDetalles + " ]";
    }
    
}

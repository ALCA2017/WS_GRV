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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vacpc
 */
@Entity
@Table(schema = "bd_wsgrv", name = "niv_gra_matriculados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivGraMatriculados.findAll", query = "SELECT n FROM NivGraMatriculados n"),
    @NamedQuery(name = "NivGraMatriculados.findByIdNivGraMatriculados", query = "SELECT n FROM NivGraMatriculados n WHERE n.idNivGraMatriculados = :idNivGraMatriculados")})
public class NivGraMatriculados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_niv_gra_matriculados")
    private Integer idNivGraMatriculados;
    @JoinColumn(name = "id_grado", referencedColumnName = "id_grado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Grado idGrado;
    @JoinColumn(name = "id_niv_gra", referencedColumnName = "id_niv_gra")
    @ManyToOne(fetch = FetchType.LAZY)
    private NivGra idNivGra;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nivel idNivel;
    @JoinColumn(name = "id_seccion", referencedColumnName = "id_seccion")
    @ManyToOne(fetch = FetchType.LAZY)
    private Seccion idSeccion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "usuario_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios idUsuario;

    public NivGraMatriculados() {
    }

    public NivGraMatriculados(Integer idNivGraMatriculados) {
        this.idNivGraMatriculados = idNivGraMatriculados;
    }

    public Integer getIdNivGraMatriculados() {
        return idNivGraMatriculados;
    }

    public void setIdNivGraMatriculados(Integer idNivGraMatriculados) {
        this.idNivGraMatriculados = idNivGraMatriculados;
    }

    public Grado getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Grado idGrado) {
        this.idGrado = idGrado;
    }

    public NivGra getIdNivGra() {
        return idNivGra;
    }

    public void setIdNivGra(NivGra idNivGra) {
        this.idNivGra = idNivGra;
    }

    public Nivel getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Nivel idNivel) {
        this.idNivel = idNivel;
    }

    public Seccion getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Seccion idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivGraMatriculados != null ? idNivGraMatriculados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivGraMatriculados)) {
            return false;
        }
        NivGraMatriculados other = (NivGraMatriculados) object;
        if ((this.idNivGraMatriculados == null && other.idNivGraMatriculados != null) || (this.idNivGraMatriculados != null && !this.idNivGraMatriculados.equals(other.idNivGraMatriculados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ws.grv.modelo.entidades.NivGraMatriculados[ idNivGraMatriculados=" + idNivGraMatriculados + " ]";
    }
    
}

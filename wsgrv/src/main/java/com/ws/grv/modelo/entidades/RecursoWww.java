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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(schema = "bd_wsgrv", name = "recurso_www")
@XmlRootElement
public class RecursoWww implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_recurso_www")
    private Integer idRecursoWww;
    @Size(max = 2500)
    @Column(name = "result")
    private String result;
    @Size(max = 2500)
    @Column(name = "text")
    private String text;
    @Size(max = 2500)
    @Column(name = "url")
    private String url;
    @Size(max = 2500)
    @Column(name = "referencia1")
    private String referencia1;
    @Size(max = 2500)
    @Column(name = "referencia2")
    private String referencia2;
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

    public RecursoWww() {
    }

    public RecursoWww(SesionUnidadDidactica id_sesion, String result, String text, String uRL) {
        this.idSesion   = id_sesion;
        this.result 	= result;
        this.text       = text;
        this.url 	= uRL;
    }     
    
    public RecursoWww(Integer idRecursoWww) {
        this.idRecursoWww = idRecursoWww;
    }

    public RecursoWww(Integer idRecursoWww, int estado) {
        this.idRecursoWww = idRecursoWww;
        this.estado = estado;
    }

    public Integer getIdRecursoWww() {
        return idRecursoWww;
    }

    public void setIdRecursoWww(Integer idRecursoWww) {
        this.idRecursoWww = idRecursoWww;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReferencia1() {
        return referencia1;
    }

    public void setReferencia1(String referencia1) {
        this.referencia1 = referencia1;
    }

    public String getReferencia2() {
        return referencia2;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
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
        hash += (idRecursoWww != null ? idRecursoWww.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecursoWww)) {
            return false;
        }
        RecursoWww other = (RecursoWww) object;
        if ((this.idRecursoWww == null && other.idRecursoWww != null) || (this.idRecursoWww != null && !this.idRecursoWww.equals(other.idRecursoWww))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idRecursoWww.toString();
    }
    
}

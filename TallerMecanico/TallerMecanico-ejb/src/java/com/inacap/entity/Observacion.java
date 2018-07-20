/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CarlosCoronado
 */
@Entity
@Table(name = "observacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observacion.findAll", query = "SELECT o FROM Observacion o")
    , @NamedQuery(name = "Observacion.findByIdObservacion", query = "SELECT o FROM Observacion o WHERE o.idObservacion = :idObservacion")})
public class Observacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_observacion")
    private Integer idObservacion;
    @Basic(optional = false)
    @Lob
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "orden_trabajo_id_orden_trabajo", referencedColumnName = "id_orden_trabajo")
    @ManyToOne(optional = false)
    private OrdenTrabajo ordenTrabajoIdOrdenTrabajo;

    public Observacion() {
    }

    public Observacion(Integer idObservacion) {
        this.idObservacion = idObservacion;
    }

    public Observacion(Integer idObservacion, String observacion) {
        this.idObservacion = idObservacion;
        this.observacion = observacion;
    }

    public Integer getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(Integer idObservacion) {
        this.idObservacion = idObservacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public OrdenTrabajo getOrdenTrabajoIdOrdenTrabajo() {
        return ordenTrabajoIdOrdenTrabajo;
    }

    public void setOrdenTrabajoIdOrdenTrabajo(OrdenTrabajo ordenTrabajoIdOrdenTrabajo) {
        this.ordenTrabajoIdOrdenTrabajo = ordenTrabajoIdOrdenTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObservacion != null ? idObservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observacion)) {
            return false;
        }
        Observacion other = (Observacion) object;
        if ((this.idObservacion == null && other.idObservacion != null) || (this.idObservacion != null && !this.idObservacion.equals(other.idObservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inacap.entity.Observacion[ idObservacion=" + idObservacion + " ]";
    }
    
}

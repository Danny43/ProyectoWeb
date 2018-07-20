/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CarlosCoronado
 */
@Entity
@Table(name = "dtc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtc.findAll", query = "SELECT d FROM Dtc d")
    , @NamedQuery(name = "Dtc.findByIdDtc", query = "SELECT d FROM Dtc d WHERE d.idDtc = :idDtc")})
public class Dtc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_dtc")
    private String idDtc;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "dtc_has_orden_trabajo", joinColumns = {
        @JoinColumn(name = "dtc_id_dtc", referencedColumnName = "id_dtc")}, inverseJoinColumns = {
        @JoinColumn(name = "orden_trabajo_id_orden_trabajo", referencedColumnName = "id_orden_trabajo")})
    @ManyToMany
    private List<OrdenTrabajo> ordenTrabajoList;

    public Dtc() {
    }

    public Dtc(String idDtc) {
        this.idDtc = idDtc;
    }

    public Dtc(String idDtc, String descripcion) {
        this.idDtc = idDtc;
        this.descripcion = descripcion;
    }

    public String getIdDtc() {
        return idDtc;
    }

    public void setIdDtc(String idDtc) {
        this.idDtc = idDtc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<OrdenTrabajo> getOrdenTrabajoList() {
        return ordenTrabajoList;
    }

    public void setOrdenTrabajoList(List<OrdenTrabajo> ordenTrabajoList) {
        this.ordenTrabajoList = ordenTrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDtc != null ? idDtc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dtc)) {
            return false;
        }
        Dtc other = (Dtc) object;
        if ((this.idDtc == null && other.idDtc != null) || (this.idDtc != null && !this.idDtc.equals(other.idDtc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inacap.entity.Dtc[ idDtc=" + idDtc + " ]";
    }
    
}

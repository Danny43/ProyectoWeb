/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.entity;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CarlosCoronado
 */
@Entity
@Table(name = "boleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleta.findAll", query = "SELECT b FROM Boleta b")
    , @NamedQuery(name = "Boleta.findByIdBoleta", query = "SELECT b FROM Boleta b WHERE b.idBoleta = :idBoleta")
    , @NamedQuery(name = "Boleta.findByTotal", query = "SELECT b FROM Boleta b WHERE b.total = :total")
    , @NamedQuery(name = "Boleta.findByNeto", query = "SELECT b FROM Boleta b WHERE b.neto = :neto")
    , @NamedQuery(name = "Boleta.findByIva", query = "SELECT b FROM Boleta b WHERE b.iva = :iva")
    , @NamedQuery(name = "Boleta.findByFecha", query = "SELECT b FROM Boleta b WHERE b.fecha = :fecha")})
public class Boleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_boleta")
    private Integer idBoleta;
    @Basic(optional = false)
    @Column(name = "total")
    private int total;
    @Basic(optional = false)
    @Column(name = "neto")
    private int neto;
    @Basic(optional = false)
    @Column(name = "iva")
    private int iva;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "orden_trabajo_id_orden_trabajo", referencedColumnName = "id_orden_trabajo")
    @ManyToOne(optional = false)
    private OrdenTrabajo ordenTrabajoIdOrdenTrabajo;

    public Boleta() {
    }

    public Boleta(Integer idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Boleta(Integer idBoleta, int total, int neto, int iva, Date fecha) {
        this.idBoleta = idBoleta;
        this.total = total;
        this.neto = neto;
        this.iva = iva;
        this.fecha = fecha;
    }

    public Integer getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(Integer idBoleta) {
        this.idBoleta = idBoleta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNeto() {
        return neto;
    }

    public void setNeto(int neto) {
        this.neto = neto;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (idBoleta != null ? idBoleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleta)) {
            return false;
        }
        Boleta other = (Boleta) object;
        if ((this.idBoleta == null && other.idBoleta != null) || (this.idBoleta != null && !this.idBoleta.equals(other.idBoleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inacap.entity.Boleta[ idBoleta=" + idBoleta + " ]";
    }
    
}

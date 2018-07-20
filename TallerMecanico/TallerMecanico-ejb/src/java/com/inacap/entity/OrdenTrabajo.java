/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CarlosCoronado
 */
@Entity
@Table(name = "orden_trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajo.findAll", query = "SELECT o FROM OrdenTrabajo o")
    , @NamedQuery(name = "OrdenTrabajo.findByIdOrdenTrabajo", query = "SELECT o FROM OrdenTrabajo o WHERE o.idOrdenTrabajo = :idOrdenTrabajo")
    , @NamedQuery(name = "OrdenTrabajo.findByConcluido", query = "SELECT o FROM OrdenTrabajo o WHERE o.concluido = :concluido")
    , @NamedQuery(name = "OrdenTrabajo.findByFecha", query = "SELECT o FROM OrdenTrabajo o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "OrdenTrabajo.findByKilometraje", query = "SELECT o FROM OrdenTrabajo o WHERE o.kilometraje = :kilometraje")})
public class OrdenTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_trabajo")
    private Integer idOrdenTrabajo;
    @Lob
    @Column(name = "diagnostico")
    private String diagnostico;
    @Basic(optional = false)
    @Column(name = "concluido")
    private short concluido;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "kilometraje")
    private int kilometraje;
    @ManyToMany(mappedBy = "ordenTrabajoList")
    private List<Dtc> dtcList;
    @JoinColumn(name = "mecanico_id_mecanico", referencedColumnName = "id_mecanico")
    @ManyToOne(optional = false)
    private Mecanico mecanicoIdMecanico;
    @JoinColumn(name = "vehiculo_id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoIdVehiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenTrabajoIdOrdenTrabajo")
    private List<Tarea> tareaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenTrabajoIdOrdenTrabajo")
    private List<Boleta> boletaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenTrabajoIdOrdenTrabajo")
    private List<Observacion> observacionList;

    public OrdenTrabajo() {
    }

    public OrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public OrdenTrabajo(Integer idOrdenTrabajo, short concluido, Date fecha, int kilometraje) {
        this.idOrdenTrabajo = idOrdenTrabajo;
        this.concluido = concluido;
        this.fecha = fecha;
        this.kilometraje = kilometraje;
    }

    public Integer getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public short getConcluido() {
        return concluido;
    }

    public void setConcluido(short concluido) {
        this.concluido = concluido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    @XmlTransient
    public List<Dtc> getDtcList() {
        return dtcList;
    }

    public void setDtcList(List<Dtc> dtcList) {
        this.dtcList = dtcList;
    }

    public Mecanico getMecanicoIdMecanico() {
        return mecanicoIdMecanico;
    }

    public void setMecanicoIdMecanico(Mecanico mecanicoIdMecanico) {
        this.mecanicoIdMecanico = mecanicoIdMecanico;
    }

    public Vehiculo getVehiculoIdVehiculo() {
        return vehiculoIdVehiculo;
    }

    public void setVehiculoIdVehiculo(Vehiculo vehiculoIdVehiculo) {
        this.vehiculoIdVehiculo = vehiculoIdVehiculo;
    }

    @XmlTransient
    public List<Tarea> getTareaList() {
        return tareaList;
    }

    public void setTareaList(List<Tarea> tareaList) {
        this.tareaList = tareaList;
    }

    @XmlTransient
    public List<Boleta> getBoletaList() {
        return boletaList;
    }

    public void setBoletaList(List<Boleta> boletaList) {
        this.boletaList = boletaList;
    }

    @XmlTransient
    public List<Observacion> getObservacionList() {
        return observacionList;
    }

    public void setObservacionList(List<Observacion> observacionList) {
        this.observacionList = observacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenTrabajo != null ? idOrdenTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajo)) {
            return false;
        }
        OrdenTrabajo other = (OrdenTrabajo) object;
        if ((this.idOrdenTrabajo == null && other.idOrdenTrabajo != null) || (this.idOrdenTrabajo != null && !this.idOrdenTrabajo.equals(other.idOrdenTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inacap.entity.OrdenTrabajo[ idOrdenTrabajo=" + idOrdenTrabajo + " ]";
    }
    
}

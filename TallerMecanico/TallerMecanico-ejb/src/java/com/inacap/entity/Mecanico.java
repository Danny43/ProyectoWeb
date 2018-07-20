/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CarlosCoronado
 */
@Entity
@Table(name = "mecanico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mecanico.findAll", query = "SELECT m FROM Mecanico m")
    , @NamedQuery(name = "Mecanico.findByIdMecanico", query = "SELECT m FROM Mecanico m WHERE m.idMecanico = :idMecanico")
    , @NamedQuery(name = "Mecanico.findByRut", query = "SELECT m FROM Mecanico m WHERE m.rut = :rut")
    , @NamedQuery(name = "Mecanico.findByNombres", query = "SELECT m FROM Mecanico m WHERE m.nombres = :nombres")
    , @NamedQuery(name = "Mecanico.findByApellidoPaterno", query = "SELECT m FROM Mecanico m WHERE m.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Mecanico.findByApellidoMaterno", query = "SELECT m FROM Mecanico m WHERE m.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "Mecanico.findByContrasena", query = "SELECT m FROM Mecanico m WHERE m.contrasena = :contrasena")
    , @NamedQuery(name = "Mecanico.findByCorreoElectronico", query = "SELECT m FROM Mecanico m WHERE m.correoElectronico = :correoElectronico")})
public class Mecanico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mecanico")
    private Integer idMecanico;
    @Basic(optional = false)
    @Column(name = "rut")
    private String rut;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Basic(optional = false)
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mecanicoIdMecanico")
    private List<OrdenTrabajo> ordenTrabajoList;

    public Mecanico() {
    }

    public Mecanico(Integer idMecanico) {
        this.idMecanico = idMecanico;
    }

    public Mecanico(Integer idMecanico, String rut, String nombres, String apellidoPaterno, String apellidoMaterno, String contrasena) {
        this.idMecanico = idMecanico;
        this.rut = rut;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
    }

    public Integer getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(Integer idMecanico) {
        this.idMecanico = idMecanico;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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
        hash += (idMecanico != null ? idMecanico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mecanico)) {
            return false;
        }
        Mecanico other = (Mecanico) object;
        if ((this.idMecanico == null && other.idMecanico != null) || (this.idMecanico != null && !this.idMecanico.equals(other.idMecanico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inacap.entity.Mecanico[ idMecanico=" + idMecanico + " ]";
    }
    
}

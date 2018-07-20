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
@Table(name = "ano")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ano.findAll", query = "SELECT a FROM Ano a")
    , @NamedQuery(name = "Ano.findByIdAno", query = "SELECT a FROM Ano a WHERE a.idAno = :idAno")})
public class Ano implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ano")
    private Integer idAno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anoIdAno")
    private List<Vehiculo> vehiculoList;

    public Ano() {
    }

    public Ano(Integer idAno) {
        this.idAno = idAno;
    }

    public Integer getIdAno() {
        return idAno;
    }

    public void setIdAno(Integer idAno) {
        this.idAno = idAno;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAno != null ? idAno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ano)) {
            return false;
        }
        Ano other = (Ano) object;
        if ((this.idAno == null && other.idAno != null) || (this.idAno != null && !this.idAno.equals(other.idAno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inacap.entity.Ano[ idAno=" + idAno + " ]";
    }
    
}

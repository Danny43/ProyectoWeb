/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.bean;

import com.inacap.entity.Boleta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CarlosCoronado
 */
@Stateless
public class BoletaFacade extends AbstractFacade<Boleta> implements BoletaFacadeLocal {

    @PersistenceContext(unitName = "TallerMecanico-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BoletaFacade() {
        super(Boleta.class);
    }

    @Override
    public int calcularIVA(Boleta boleta, int neto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calcularTotal(Boleta boleta, int iva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

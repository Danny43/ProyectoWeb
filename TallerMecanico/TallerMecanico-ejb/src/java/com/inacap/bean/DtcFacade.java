/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.bean;

import com.inacap.entity.Dtc;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CarlosCoronado
 */
@Stateless
public class DtcFacade extends AbstractFacade<Dtc> implements DtcFacadeLocal {

    @PersistenceContext(unitName = "TallerMecanico-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DtcFacade() {
        super(Dtc.class);
    }
    
}

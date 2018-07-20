/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.bean;

import com.inacap.entity.Ano;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CarlosCoronado
 */
@Stateless
public class AnoFacade extends AbstractFacade<Ano> implements AnoFacadeLocal {

    @PersistenceContext(unitName = "TallerMecanico-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnoFacade() {
        super(Ano.class);
    }
    
}

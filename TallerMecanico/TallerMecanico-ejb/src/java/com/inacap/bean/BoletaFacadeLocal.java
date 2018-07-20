/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.bean;

import com.inacap.entity.Boleta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CarlosCoronado
 */
@Local
public interface BoletaFacadeLocal {

    void create(Boleta boleta);

    void edit(Boleta boleta);

    void remove(Boleta boleta);

    Boleta find(Object id);

    List<Boleta> findAll();

    List<Boleta> findRange(int[] range);

    int count();
    
    public int calcularIVA(Boleta boleta, int neto);
    
    public int calcularTotal(Boleta boleta, int iva);
    
    
    
}

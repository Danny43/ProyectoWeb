/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.bean;

import com.inacap.entity.Ano;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CarlosCoronado
 */
@Local
public interface AnoFacadeLocal {

    void create(Ano ano);

    void edit(Ano ano);

    void remove(Ano ano);

    Ano find(Object id);

    List<Ano> findAll();

    List<Ano> findRange(int[] range);

    int count();
    
}

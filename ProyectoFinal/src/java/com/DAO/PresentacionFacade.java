/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.entities.Presentacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ludy Lozano
 */
@Stateless
public class PresentacionFacade extends AbstractFacade<Presentacion> implements PresentacionFacadeLocal {

    @PersistenceContext(unitName = "ProyectoFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresentacionFacade() {
        super(Presentacion.class);
    }
    
}

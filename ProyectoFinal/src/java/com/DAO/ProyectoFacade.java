/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.entities.Proyecto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ludy Lozano
 */
@Stateless
public class ProyectoFacade extends AbstractFacade<Proyecto> implements ProyectoFacadeLocal {

    @PersistenceContext(unitName = "ProyectoFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoFacade() {
        super(Proyecto.class);
    }
    
}

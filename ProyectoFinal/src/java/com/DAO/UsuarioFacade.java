/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ludy Lozano
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "ProyectoFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario login(Long noidentificacion, String contraseña) {
        try {
            TypedQuery<Usuario> q = getEntityManager().createNamedQuery("Usuario.findLogin", Usuario.class);
            q.setParameter("noIdentificacion", noidentificacion);
            q.setParameter("contraseña", contraseña);
            return q.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
    
}

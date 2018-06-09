/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author wmoramor
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

    @Override
    public List<Usuario> usuariosInactivos() {
        System.out.println("Ejecutando metodo buscar usuarios inactivos");
        Query q = em.createNativeQuery("SELECT u.* " +
                                "FROM usuarios AS u join usuarioswithroles join roles " +
                                "on u.noIdentificacion = usuarioswithroles.noIdentificacion AND usuarioswithroles.idRol  = roles.idRol AND u.estado=?;", Usuario.class);
        q.setParameter(1, 2);
        List<Usuario> usuarios = q.getResultList();

        for (Usuario u : usuarios) {
            System.out.println("Listando usuarios Administrador");
        }
        System.out.println(usuarios);
        
        return usuarios;
    }
    
}

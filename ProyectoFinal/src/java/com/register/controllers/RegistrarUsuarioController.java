/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.register.controllers;

import com.DAO.RolFacadeLocal;
import com.DAO.UsuarioFacadeLocal;
import com.entities.Rol;
import com.entities.Usuario;
import com.util.MessageUtil;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author wmoramor
 */
@Named(value = "registrarUsuarioController")
@RequestScoped
public class RegistrarUsuarioController {

    @EJB
    private UsuarioFacadeLocal ufl;
    @EJB
    private RolFacadeLocal rfl;
    
    private Usuario usuarioNuevo;
    
    public RegistrarUsuarioController() {
    }
    
    @PostConstruct
    public void init(){
        usuarioNuevo = new Usuario();
    }
    
     public Usuario getUsuarioNuevo() {
        return usuarioNuevo;
    }

    public void setUsuarioNuevo(Usuario usuarioNuevo) {
        this.usuarioNuevo = usuarioNuevo;
    }
    
    
    public void registrar(){
        if (usuarioNuevo != null) {
            usuarioNuevo.setRoles(new ArrayList<Rol>());
            usuarioNuevo.getRoles().add(rfl.find(3));
            usuarioNuevo.setEstado(1);
            ufl.create(usuarioNuevo);
            MessageUtil.enviarMensajeInformacion("form-crear", "Registro exitoso!", "El usuario se ha registrado correctamente");
            init();
        }
        else
        {
            MessageUtil.enviarMensajeError("form-crear", "Error", "No se han diligenciado datos");
        }
    }

   
    
    
    
}

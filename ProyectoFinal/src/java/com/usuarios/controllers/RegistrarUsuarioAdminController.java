package com.usuarios.controllers;

import com.DAO.UsuarioFacadeLocal;
import com.entities.Usuario;
import com.util.MessageUtil;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "registrarUsuarioAdminController")
@RequestScoped
public class RegistrarUsuarioAdminController {
    
    @EJB
    private UsuarioFacadeLocal ufl;
    
    private Usuario usuarioNuevo;    
    private String estadoString;
    
    public RegistrarUsuarioAdminController() {
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

    public String getEstadoString() {
        return estadoString;
    }

    public void setEstadoString(String estadoString) {
        this.estadoString = estadoString;
    }
    
    
    
    public void registrarUsuario(){
        if (usuarioNuevo != null) {
            if (getEstadoString().equalsIgnoreCase("Activo")) {
                usuarioNuevo.setEstado(1);
            }else if (getEstadoString().equalsIgnoreCase("Bloqueado")) {
                usuarioNuevo.setEstado(2);
            }
            ufl.create(usuarioNuevo);
            MessageUtil.enviarMensajeInformacion("form-crear-admin", "Registro exitoso!", "El usuario se ha registrado correctamente");
            init();
        }
        else
        {
            MessageUtil.enviarMensajeError("form-crear-admin", "Error", "No se han diligenciado datos");
        }
    }
    
    
    
}

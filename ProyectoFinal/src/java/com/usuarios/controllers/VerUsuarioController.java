package com.usuarios.controllers;

import com.entities.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;


@Named(value = "verUsuarioController")
@SessionScoped
public class VerUsuarioController implements Serializable {

    private Usuario usuarioSeleccionado;
    
    public VerUsuarioController() {
    }
    
    @PostConstruct
    public void init(){}

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }
    
    public String verUsuario(Usuario u){
    this.usuarioSeleccionado = u;
    return "/vistasSinProteccion/administrador/verMas.xhtml?faces-redirect=true";
    }
}

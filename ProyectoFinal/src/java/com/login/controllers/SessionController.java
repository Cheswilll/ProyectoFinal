package com.login.controllers;

import com.DAO.UsuarioFacade;
import com.entities.Permiso;
import com.entities.Rol;
import com.entities.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable{
    @EJB
    private SessionRule sr;
    
    private UsuarioFacade ufl;
   
    
    private String contraseña;
    private Long noidentificacion;
    private Rol rolSeleccionado;
    private Usuario usuario;

    public SessionController() {
    }
    
    @PostConstruct
    public void init(){
        
    }
    
    

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Long getNoidentificacion() {
        return noidentificacion;
    }

    public void setNoidentificacion(Long noidentificacion) {
        this.noidentificacion = noidentificacion;
    }

    public Rol getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Rol rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public UsuarioFacade getUfl() {
        return ufl;
    }

    public void setUfl(UsuarioFacade ufl) {
        this.ufl = ufl;
    }
    
    
    
    
    
    
    public String iniciarSesion(){
        String urlDestino = "";
        usuario = sr.iniciar(noidentificacion, contraseña);
        if(usuario != null){
            rolSeleccionado = sr.validarRol(usuario);
            if(rolSeleccionado != null){
                urlDestino = "/app/inicio.xhtml?faces-redirect=true";
            } else{
                usuario = null;
            }
        }
        return urlDestino;
    }
    
    public Usuario usuarioSesion(){
        usuario.getNoIdentificacion();
        return usuario;
    }
    
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuario = null;
        rolSeleccionado = null;
        contraseña = "";
        noidentificacion = null;
        return "/index.xhtml?faces-redirect=true";
    }
    
    public Boolean inicioSesion(){
        return (usuario != null);
    }
    
    
    public Boolean tienePermiso(String urlRecurso){
        if(urlRecurso.endsWith("app/index.xhtml")){
            return true;
        }
        for (Permiso p : rolSeleccionado.getPermisos()) {
            if(p.getUrl() != null && urlRecurso.endsWith(p.getUrl())){
                return true;
            }
        }
        return false;
    }
    
    
    @PreDestroy
    public void perDestroy(){
        cerrarSesion();
    }
    
    
    
    
}

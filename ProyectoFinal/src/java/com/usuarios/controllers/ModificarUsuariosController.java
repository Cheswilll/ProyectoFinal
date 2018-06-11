/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.controllers;

import com.DAO.UsuarioFacadeLocal;
import com.entities.Usuario;
import com.login.controllers.SessionController;
import com.util.MessageUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author wmoramor
 */
@Named(value = "modificarUsuariosController")
@SessionScoped
public class ModificarUsuariosController implements Serializable {

    @EJB
    private UsuarioFacadeLocal ufl;
    
    private Usuario usuarioSeleccionado;
    
    private Usuario usuarioSession;
    
    @Inject
    private SessionController sc;
    
    
    public ModificarUsuariosController() {
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public Usuario getUsuarioSession() {
        return usuarioSession = sc.getUsuario();
    }

    public void setUsuarioSession() {
        this.usuarioSession = sc.getUsuario();
    }
    
    public void actulaizarInformacionUsuario(){
        try {
            ufl.edit(usuarioSeleccionado);
            MessageUtil.enviarMensajeInformacion("form-editar", "Actualización", "Los datos del usuarios se han actualizado correctamente.");
        } catch (Exception e) {
            MessageUtil.enviarMensajeError("form-editar","Error al modificar los datos del usuario", "Error inesperado");
        }
    }
    
    public void actualizarPerfil(){
        try {
            ufl.edit(usuarioSession);
            MessageUtil.enviarMensajeInformacion("form-editar-perfil", "Actualización", "Los datos del usuarios se han actualizado correctamente.");
        } catch (Exception e) {
            MessageUtil.enviarMensajeError("form-editar-perfil","Error al modificar los datos del usuario", "Error inesperado");
        }
    }
    
    public String preModificar(Usuario u){
        setUsuarioSeleccionado(u);
        return "/vistasSinProteccion/administrador/actualizarInformacionUsuario.xhtml?faces-redirect=true";
    }
    
    
    public void cambioDeEstado(Usuario u){
        try {
            if (u.getEstado() == 1) {
                u.setEstado(2);
            } else {
                u.setEstado(1);
            }
            ufl.edit(u);
            MessageUtil.enviarMensajeInformacion("form-data-table-usuarios", "Actualización", "Se ha cambiado el estado del usuario.");
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.enviarMensajeErrorGlobal("Errcambiar el estado del usuario", e.getStackTrace().toString());
        }   
    }
    
    public String getIconUsuarioBloqueo(Usuario u){
        return (u.getEstado() == 1) ? "lock": "unlock";
    }
    
    
}

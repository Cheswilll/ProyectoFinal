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
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "listarUsuariosController")
@ViewScoped
public class ListarUsuariosController implements Serializable {

    @EJB
    private UsuarioFacadeLocal ufl;
    
    @Inject
    private SessionController sc;
    
    private List<Usuario> usuarios;
    private String estado;
    
    private Usuario usuarioSeleccionado;
    
    private List<Usuario> usuariosInactivos;

    public ListarUsuariosController() {
        
    }

    @PostConstruct
    public void init() {
        listarUsuarios();
        listarUsuariosInactivos();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public List<Usuario> getUsuariosInactivos() {
        return usuariosInactivos;
    }

    public void setUsuariosInactivos(List<Usuario> usuariosInactivos) {
        this.usuariosInactivos = usuariosInactivos;
    }
    
    public void listarUsuarios() {
        usuarios = ufl.findAll();
    }
    
    public void listarUsuariosInactivos(){
        usuariosInactivos = ufl.usuariosInactivos();
    }

    public String validarEstado(Integer idEstado) {
        if (idEstado == 1) {
            estado = "Activo";
        } else if (idEstado == 2) {
            estado = "Bloqueado";
        }
        return estado;
    }
    
    public void eliminarUsuario(){
    Usuario usuarioSession = sc.getUsuario();
        if (usuarioSession.getNoIdentificacion().intValue() != usuarioSeleccionado.getNoIdentificacion()) {
            ufl.remove(usuarioSeleccionado);
            listarUsuarios();
            MessageUtil.enviarMensajeError("tabla_usuarios", "Eliminación exitosa", "Se ha eliminado");
        }else{
            MessageUtil.enviarMensajeError("tabla_usuarios", "Error", "No se puede eliminar usted mismo");
        }
    }
    
    public void cambioDeEstado(Usuario u){
        try {
            if (u.getEstado() == 1) {
                u.setEstado(2);
            } else {
                u.setEstado(1);
            }
            ufl.edit(u);
            MessageUtil.enviarMensajeInformacion("tabla_usuarios", "Actualización", "Se ha cambiado el estado del usuario.");
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.enviarMensajeError("tabla_usuarios","Error al cambiar el estado", "Error desconocido");
        }   
    }
    
    public String getIconUsuarioBloqueo(Usuario u){
        return (u.getEstado() == 1) ? "lock": "unlock";
    }
    

    

}
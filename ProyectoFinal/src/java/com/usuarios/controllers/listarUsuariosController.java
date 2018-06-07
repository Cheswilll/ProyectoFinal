/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.controllers;

import com.DAO.UsuarioFacadeLocal;
import com.entities.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author wmoramor
 */
@Named(value = "listarUsuariosController")
@ViewScoped
public class listarUsuariosController implements  Serializable{

    @EJB
    private UsuarioFacadeLocal ufl;
    private List<Usuario> usuarios;
    private String estado;
    
    public listarUsuariosController() {
    }
    
    @PostConstruct
    public void init(){
     recargarUsuarios();
    }
    
    public void recargarUsuarios(){
        usuarios = ufl.findAll();
    }
    
    public String validarEstado(Integer idEstado){
        if (idEstado == 1) {
            estado = "Activo";
        }else if(idEstado == 2){
            estado = "Bloqueado";
        }
        return estado;
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
    
    
    
    
}

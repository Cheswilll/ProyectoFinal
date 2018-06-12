/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estudiantes.controllers;

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
@Named(value = "listarEstudiantesController")
@ViewScoped
public class ListarEstudiantesController implements Serializable{

    @EJB
    private UsuarioFacadeLocal ufl;
    
    private List<Usuario> usuariosEstudiantes;
    
    public ListarEstudiantesController() {
    }
    
    @PostConstruct
    public void init(){
        listarEstudiantes();
    }

    public List<Usuario> getUsuariosEstudiantes() {
        return usuariosEstudiantes;
    }

    public void setUsuariosEstudiantes(List<Usuario> usuariosEstudiantes) {
        this.usuariosEstudiantes = usuariosEstudiantes;
    }
    
    public void listarEstudiantes(){
        usuariosEstudiantes = ufl.usuariosEstudiantes();
    }
    
}

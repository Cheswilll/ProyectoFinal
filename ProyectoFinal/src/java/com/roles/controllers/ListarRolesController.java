package com.roles.controllers;

import com.DAO.RolFacadeLocal;
import com.entities.Rol;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "listarRolesController")
@ViewScoped
public class ListarRolesController implements  Serializable{

    @EJB
    private RolFacadeLocal rfl;
    private List<Rol> roles;
    
    public ListarRolesController() {
    }
    
    @PostConstruct
    public void init(){
        listarRoles();
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    
    public void listarRoles(){
        roles = rfl.findAll();
    }
    
}

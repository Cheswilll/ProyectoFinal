/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roles.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author wmoramor
 */
@Named(value = "listarRolesStringController")
@ViewScoped
public class ListarRolesStringController implements Serializable{

    private ArrayList<String> roles = new ArrayList<String>();
    private String admin = "Administrador";
    private String profe = "Profesor";
    private String est = "Estudiante";
    
    public ListarRolesStringController() {
    }
    
    @PostConstruct
    public void init(){
        listarRoles();
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }
    
    public void listarRoles(){
        roles.add(admin);
        roles.add(profe);
        roles.add(est);
    }
    
}

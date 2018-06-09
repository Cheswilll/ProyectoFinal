/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author wmoramor
 */
@Named(value = "listarEstadosController")
@SessionScoped
public class ListarEstadosController implements Serializable {

    private String activo="Activo";
    private String bloqueado="Bloqueado";
    private Integer act=1;
    private Integer bloq=2;
    ArrayList<String> estados = new ArrayList<String>();
    
    public ListarEstadosController() {
    }
    
    @PostConstruct
    public void init(){
        listarEstado();
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }
    
    
    public void listarEstado(){
        estados.add(activo);
        estados.add(bloqueado);
    }
    
    
    
    
}

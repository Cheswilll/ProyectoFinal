package com.proyectos.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;


@Named(value = "listarEstadosProyectosController")
@SessionScoped
public class ListarEstadosProyectosController implements Serializable {
    
    private String disponible = "Disponible";
    private String ocupado = "Ocupado";
    private String cerrado = "Cerrado";
    ArrayList<String> estadosProyecto = new ArrayList<String>();
    
    public ListarEstadosProyectosController() {
    }
    
    @PostConstruct
    public void init(){
        listarEstadosProyecto();
    }

    public ArrayList<String> getEstadosProyecto() {
        return estadosProyecto;
    }

    public void setEstadosProyecto(ArrayList<String> estadosProyecto) {
        this.estadosProyecto = estadosProyecto;
    }
    
    
    public void listarEstadosProyecto(){
        estadosProyecto.add(disponible);
        estadosProyecto.add(ocupado);
        estadosProyecto.add(cerrado);
    }
    
}

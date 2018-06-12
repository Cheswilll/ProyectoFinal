package com.presentaciones.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

@Named(value = "listarEstadosPresentacionController")
@SessionScoped
public class ListarEstadosPresentacionController implements Serializable {

    private String disponible = "Disponible";
    private String ocupado = "Ocupado";
    private String cerrado = "Cerrado";
    ArrayList<String> estadosPresentacion = new ArrayList<>();
    
    public ListarEstadosPresentacionController() {
    }
    
    @PostConstruct
    public void init(){
        listarEstadosPresentacion();
    }

    public ArrayList<String> getEstadosPresentacion() {
        return estadosPresentacion;
    }

    public void setEstadosPresentacion(ArrayList<String> estadosPresentacion) {
        this.estadosPresentacion = estadosPresentacion;
    }
    
    public void listarEstadosPresentacion(){
        estadosPresentacion.add(disponible);
        estadosPresentacion.add(ocupado);
        estadosPresentacion.add(cerrado);
    }
    
}

package com.proyectos.controllers;

import com.DAO.GrupoFacadeLocal;
import com.DAO.ProyectoFacadeLocal;
import com.entities.Grupo;
import com.entities.Proyecto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "listarGruposController")
@ViewScoped
public class ListarGruposController implements Serializable{

    @EJB
    private GrupoFacadeLocal gfl;
    
    @EJB
    private ProyectoFacadeLocal pfl;
    
    
    private List<Proyecto> proyectosDisponibles;
    
    private List<Grupo> grupos;
    
    private Proyecto proyectoSeleccionado;
    
    private Integer idProyecto;
    
  
    public ListarGruposController() {
    }
    
    @PostConstruct
    public void init(){
        listarProyectosDisponibles();
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Proyecto getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    public void setProyectoSeleccionado(Proyecto proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
    }

    public Integer getIdProyecto() {
        return idProyecto = proyectoSeleccionado.getIdProyecto();
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public List<Proyecto> getProyectosDisponibles() {
        return proyectosDisponibles;
    }

    public void setProyectosDisponibles(List<Proyecto> proyectosDisponibles) {
        this.proyectosDisponibles = proyectosDisponibles;
    }
    
    
    
    public void listarGrupos(){
        grupos = gfl.listarGrupos(getProyectoSeleccionado().getIdProyecto());
    }
    
    public void listarProyectosDisponibles(){
        proyectosDisponibles = pfl.proyectosDisponibles();
    }
    
}

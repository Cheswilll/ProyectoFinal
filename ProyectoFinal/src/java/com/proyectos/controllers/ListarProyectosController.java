package com.proyectos.controllers;

import com.DAO.GrupoFacadeLocal;
import com.DAO.ProyectoFacadeLocal;
import com.entities.Grupo;
import com.entities.Proyecto;
import com.util.MessageUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "listarProyectosController")
@ViewScoped
public class ListarProyectosController implements Serializable{

    @EJB
    private ProyectoFacadeLocal pfl;
    
    private List<Proyecto> proyectos;
    

    private List<Proyecto> proyectosCerrados;
    
    private List<Proyecto> proyectosDisponibles;

    private String estadoProyecto;
    
    private Proyecto proyectoSeleccionado;
    
    public ListarProyectosController() {
    }
    
    @PostConstruct
    public void init(){
        listarProyectos();
        listarProyectosCerrados();
        listarProyectosDisponibles();
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public Proyecto getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    public void setProyectoSeleccionado(Proyecto proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
    }

    public List<Proyecto> getProyectosCerrados() {
        return proyectosCerrados;
    }

    public void setProyectosCerrados(List<Proyecto> proyectosCerrados) {
        this.proyectosCerrados = proyectosCerrados;
    }

    public List<Proyecto> getProyectosDisponibles() {
        return proyectosDisponibles;
    }

    public void setProyectosDisponibles(List<Proyecto> proyectosDisponibles) {
        this.proyectosDisponibles = proyectosDisponibles;
    }

    
    
    
    
    
    public void listarProyectos(){
        proyectos = pfl.findAll();
    }
    
    public void listarProyectosCerrados(){
        proyectosCerrados = pfl.proyectosCerrados();
    }
    
    public void listarProyectosDisponibles(){
        proyectosDisponibles = pfl.proyectosDisponibles();
    }
  
    public String validarEstadoProyecto(Integer idEstado) {
        if (idEstado == 1) {
            estadoProyecto = "Disponible";
        } else if (idEstado == 2) {
            estadoProyecto = "Ocupado";
        } else if (idEstado == 3){
            estadoProyecto = "Cerrado";
        }
        return estadoProyecto;
    }
    
    public void eliminarProyecto(){
        try {
            pfl.remove(proyectoSeleccionado);
            listarProyectos();
            listarProyectosCerrados();
            MessageUtil.enviarMensajeError("tabla_proyectos_cerrados", "Eliminación exitosa", "Se ha eliminado");    
        } catch (Exception e) {
            MessageUtil.enviarMensajeError("tabla_proyectos_cerrados", "Error", "No se puede eliminar este proyecto");
        
        }   
    }
}

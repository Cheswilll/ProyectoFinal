package com.proyectos.controllers;

import com.DAO.ProyectoFacadeLocal;
import com.entities.Proyecto;
import com.util.MessageUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

@Named(value = "modificarProyectosController")
@SessionScoped
public class ModificarProyectosController implements Serializable {

    @EJB
    private ProyectoFacadeLocal pfl;
    
    private Proyecto proyectoSeleccionado;
    
    public ModificarProyectosController() {
    }

    public Proyecto getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    public void setProyectoSeleccionado(Proyecto proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
    }
    
    public void actulaizarInformacionProyecto(){
        try {
            pfl.edit(proyectoSeleccionado);
            MessageUtil.enviarMensajeInformacion("form-editar-proyecto", "Actualización", "Los datos del proyecto se han actualizado correctamente.");
        } catch (Exception e) {
            MessageUtil.enviarMensajeError("form-editar-proyecto","Error al modificar los datos del proyecto", "Error inesperado");
        }
    }
    
    public String preModificarProyecto(Proyecto p){
        setProyectoSeleccionado(p);
        return "/vistasSinProteccion/profesor/actualizarInformacionProyecto.xhtml?faces-redirect=true";
    }
    
}

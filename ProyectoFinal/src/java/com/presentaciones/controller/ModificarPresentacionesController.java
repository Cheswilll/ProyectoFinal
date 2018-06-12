package com.presentaciones.controller;

import com.DAO.PresentacionFacadeLocal;
import com.entities.Presentacion;
import com.util.MessageUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;


@Named(value = "modificarPresentacionesController")
@SessionScoped
public class ModificarPresentacionesController implements Serializable {

    @EJB
    private PresentacionFacadeLocal prfl;
    
    private Presentacion presentacionSeleccionada;
    
    public ModificarPresentacionesController() {
    }

    public Presentacion getPresentacionSeleccionada() {
        return presentacionSeleccionada;
    }

    public void setPresentacionSeleccionada(Presentacion presentacionSeleccionada) {
        this.presentacionSeleccionada = presentacionSeleccionada;
    }
 
    public void actulaizarInformacionPresentacion(){
        try {
            prfl.edit(presentacionSeleccionada);
            MessageUtil.enviarMensajeInformacion("form-editar-presentaciones", "Actualización", "Los datos del proyecto se han actualizado correctamente.");
        } catch (Exception e) {
            MessageUtil.enviarMensajeError("form-editar-presentaciones","Error al modificar los datos del proyecto", "Error inesperado");
        }
    }
    
    public String preModificarPresentacion(Presentacion p){
        setPresentacionSeleccionada(p);
        return "/vistasSinProteccion/profesor/actualizarInformacionPresentacion.xhtml?faces-redirect=true";
    }
}

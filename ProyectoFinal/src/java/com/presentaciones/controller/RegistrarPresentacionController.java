package com.presentaciones.controller;

import com.DAO.PresentacionFacadeLocal;
import com.entities.Presentacion;
import com.util.MessageUtil;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@Named(value = "registrarPresentacionController")
@RequestScoped
public class RegistrarPresentacionController {

    @EJB
    private PresentacionFacadeLocal prfl;
    
    @Inject
    private ListarPresentacionesController lprc;
    
    private Presentacion nuevaPresentacion;
    
    private String estadoPresentacion;
    
    public RegistrarPresentacionController() {
    }
    
    @PostConstruct
    public void init(){
        nuevaPresentacion = new Presentacion();
        lprc.listarPresentaciones();
        lprc.listarPresentacionesCerradas();
    }

    public Presentacion getNuevaPresentacion() {
        return nuevaPresentacion;
    }

    public void setNuevaPresentacion(Presentacion nuevaPresentacion) {
        this.nuevaPresentacion = nuevaPresentacion;
    }

    public String getEstadoPresentacion() {
        return estadoPresentacion;
    }

    public void setEstadoPresentacion(String estadoPresentacion) {
        this.estadoPresentacion = estadoPresentacion;
    }
    
    
    public void registrarPresentacion() {
        if (nuevaPresentacion != null) {
            if (getEstadoPresentacion().equalsIgnoreCase("Disponible")) {
                nuevaPresentacion.setEstadoPresentacion(1);
            } else if (getEstadoPresentacion().equalsIgnoreCase("Ocupado")) {
                nuevaPresentacion.setEstadoPresentacion(2);
            } else if(getEstadoPresentacion().equalsIgnoreCase("Cerrado")){
                nuevaPresentacion.setEstadoPresentacion(3);
            }
            prfl.create(nuevaPresentacion);
            MessageUtil.enviarMensajeInformacion("form-crear-presentacion", "Registro exitoso!", "La presentación se ha registrado correctamente");
            init();
        } else {
            MessageUtil.enviarMensajeError("form-crear-presentacion", "Error", "No se han diligenciado datos");
        }
    }
    
    
    
    
}

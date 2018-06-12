package com.presentaciones.controller;

import com.DAO.PresentacionFacadeLocal;
import com.entities.Presentacion;
import com.login.controllers.SessionController;
import com.util.MessageUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "listarPresentacionesController")
@ViewScoped
public class ListarPresentacionesController implements Serializable {

    @EJB
    private PresentacionFacadeLocal prfl;

    @Inject
    private SessionController sc;

    private List<Presentacion> presentaciones;

    private List<Presentacion> presentacionesCerradas;
    private List<Presentacion> presentacionesDisponibles;
    private List<Presentacion> presentacionesAgregadas;

    private Presentacion presentacionSeleccionada;

    private String estadoPresentacion;

    public ListarPresentacionesController() {
    }

    @PostConstruct
    public void init() {
        listarPresentacionesCerradas();
        listarPresentaciones();
        listarPresentacionesDisponibles();
        listarPresentacionesAgregadas();
    }

    public List<Presentacion> getPresentaciones() {
        return presentaciones;
    }

    public void setPresentaciones(List<Presentacion> presentaciones) {
        this.presentaciones = presentaciones;
    }

    public String getEstadoPresentacion() {
        return estadoPresentacion;
    }

    public void setEstadoPresentacion(String estadoPresentacion) {
        this.estadoPresentacion = estadoPresentacion;
    }

    public Presentacion getPresentacionSeleccionada() {
        return presentacionSeleccionada;
    }

    public void setPresentacionSeleccionada(Presentacion presentacionSeleccionada) {
        this.presentacionSeleccionada = presentacionSeleccionada;
    }

    public List<Presentacion> getPresentacionesCerradas() {
        return presentacionesCerradas;
    }

    public void setPresentacionesCerradas(List<Presentacion> presentacionesCerradas) {
        this.presentacionesCerradas = presentacionesCerradas;
    }

    public List<Presentacion> getPresentacionesDisponibles() {
        return presentacionesDisponibles;
    }

    public void setPresentacionesDisponibles(List<Presentacion> presentacionesDisponibles) {
        this.presentacionesDisponibles = presentacionesDisponibles;
    }

    public List<Presentacion> getPresentacionesAgregadas() {
        return presentacionesAgregadas;
    }

    public void setPresentacionesAgregadas(List<Presentacion> presentacionesAgregadas) {
        this.presentacionesAgregadas = presentacionesAgregadas;
    }
    
    public void listarPresentaciones() {
        presentaciones = prfl.findAll();
    }

    public void listarPresentacionesCerradas() {
        presentacionesCerradas = prfl.presentacionesCerradas();
    }

    public void listarPresentacionesDisponibles() {
        presentacionesDisponibles = prfl.presentacionesDisponibles();
    }
    
    

    public String validarEstadoPresentacion(Integer idEstado) {
        if (idEstado == 1) {
            estadoPresentacion = "Disponible";
        } else if (idEstado == 2) {
            estadoPresentacion = "Ocupado";
        } else if (idEstado == 3) {
            estadoPresentacion = "Cerrado";
        }
        return estadoPresentacion;
    }

    public void agregarPresentacion() {
        try {
            prfl.registrarPresentacion(presentacionSeleccionada.getIdPresentacion(), sc.getNoidentificacion());
            MessageUtil.enviarMensajeInformacion("tabla_presentaciones", "Exito!", "Se ha agregado correctamente ");
        } catch (Exception e) {
            MessageUtil.enviarMensajeInformacion("tabla_presentaciones", "Error", "No se puede agregar ");
        }
    }
    
    public void listarPresentacionesAgregadas(){
        try {
           presentacionesAgregadas = prfl.presentacionesAgregadas(sc.getNoidentificacion());
        } catch (Exception e) {
             MessageUtil.enviarMensajeInformacion("tabla_presentaciones_agregadas", "Error", "No hay agregadas ");
        }
    }

    public void eliminarPresentacion() {
        try {
            prfl.remove(presentacionSeleccionada);
            listarPresentaciones();
            listarPresentacionesCerradas();
        } catch (Exception e) {
            MessageUtil.enviarMensajeError("tabla_presentaciones_cerradas", "Error", "No se puede eliminar esta presentación");

        }
    }

}

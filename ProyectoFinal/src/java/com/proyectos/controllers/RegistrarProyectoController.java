package com.proyectos.controllers;

import com.DAO.GrupoFacadeLocal;
import com.DAO.ProyectoFacadeLocal;
import com.entities.Grupo;
import com.entities.Proyecto;
import com.util.MessageUtil;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "registrarProyectoController")
@RequestScoped
public class RegistrarProyectoController {

    @EJB
    private ProyectoFacadeLocal pfl;

    @EJB
    private GrupoFacadeLocal gfl;

    @Inject
    private ListarProyectosController lpc;

    private Proyecto proyectoNuevo;
    private Grupo grupoNuevo;
    private String estadoProyectoString;

    public RegistrarProyectoController() {
    }

    @PostConstruct
    public void init() {
        proyectoNuevo = new Proyecto();
        lpc.listarProyectos();
    }

    public Proyecto getProyectoNuevo() {
        return proyectoNuevo;
    }

    public void setProyectoNuevo(Proyecto proyectoNuevo) {
        this.proyectoNuevo = proyectoNuevo;
    }

    public String getEstadoProyectoString() {
        return estadoProyectoString;
    }

    public void setEstadoProyectoString(String estadoProyectoString) {
        this.estadoProyectoString = estadoProyectoString;
    }

    public Grupo getGrupoNuevo() {
        return grupoNuevo;
    }

    public void setGrupoNuevo(Grupo grupoNuevo) {
        this.grupoNuevo = grupoNuevo;
    }

    public void registrarProyecto() {
        if (proyectoNuevo != null) {
            if (getEstadoProyectoString().equalsIgnoreCase("Disponible")) {
                proyectoNuevo.setEstadoProyecto(1);
            } else if (getEstadoProyectoString().equalsIgnoreCase("Ocupado")) {
                proyectoNuevo.setEstadoProyecto(2);
            } else if (getEstadoProyectoString().equalsIgnoreCase("Cerrado")) {
                proyectoNuevo.setEstadoProyecto(3);
            }
            pfl.create(proyectoNuevo);
            init();
            MessageUtil.enviarMensajeInformacion("form-crear-proyecto", "Registro exitoso!", "El proyecto se ha registrado correctamente");
        } else {
            MessageUtil.enviarMensajeError("form-crear-proyecto", "Error", "No se han diligenciado datos");
        }
    }
    


}

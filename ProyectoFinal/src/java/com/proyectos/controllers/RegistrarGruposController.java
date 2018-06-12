package com.proyectos.controllers;

import com.DAO.GrupoFacadeLocal;
import com.entities.Grupo;
import com.entities.Proyecto;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;

@Named(value = "registrarGruposController")
@ViewScoped
public class RegistrarGruposController implements Serializable {

    @EJB
    private GrupoFacadeLocal gfl;

    private Grupo nuevoGrupo;

    private Integer cantidadGrupos;
    private Proyecto proyecto;
    private Integer cantidadEstudiantes;

    public RegistrarGruposController() {
    }

    @PostConstruct
    public void init() {
        nuevoGrupo = new Grupo();
    }

    public Grupo getNuevoGrupo() {
        return nuevoGrupo;
    }

    public void setNuevoGrupo(Grupo nuevoGrupo) {
        this.nuevoGrupo = nuevoGrupo;
    }

    public Integer getCantidadGrupos() {
        return cantidadGrupos;
    }

    public void setCantidadGrupos(Integer cantidadGrupos) {
        this.cantidadGrupos = cantidadGrupos;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Integer getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(Integer cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public void registrarGrupo() {
        if (nuevoGrupo != null) {
            proyecto = nuevoGrupo.getIdProyecto();
            cantidadEstudiantes = nuevoGrupo.getCantidadEstudiantes();
            for (int i = 0; i < getCantidadGrupos(); i++) {
                for (int j = 0; j < getCantidadEstudiantes(); j++) {
                    nuevoGrupo.setIdProyecto(proyecto);
                    nuevoGrupo.setCantidadEstudiantes(cantidadEstudiantes);
                    nuevoGrupo.setNombreGrupo("Grupo " + i);
                    gfl.create(nuevoGrupo);
                    init();
                }

            }
        }
    }

}

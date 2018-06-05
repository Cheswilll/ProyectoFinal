/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wmoramor
 */
@Entity
@Table(name = "proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByIdProyecto", query = "SELECT p FROM Proyecto p WHERE p.idProyecto = :idProyecto")
    , @NamedQuery(name = "Proyecto.findByNombreProyecto", query = "SELECT p FROM Proyecto p WHERE p.nombreProyecto = :nombreProyecto")
    , @NamedQuery(name = "Proyecto.findByEstadoProyecto", query = "SELECT p FROM Proyecto p WHERE p.estadoProyecto = :estadoProyecto")
    , @NamedQuery(name = "Proyecto.findByFechaProyecto", query = "SELECT p FROM Proyecto p WHERE p.fechaProyecto = :fechaProyecto")
    , @NamedQuery(name = "Proyecto.findByDescripcionProyecto", query = "SELECT p FROM Proyecto p WHERE p.descripcionProyecto = :descripcionProyecto")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProyecto")
    private Integer idProyecto;
    @Basic(optional = false)
    @Column(name = "nombreProyecto")
    private String nombreProyecto;
    @Column(name = "estadoProyecto")
    private Integer estadoProyecto;
    @Column(name = "fechaProyecto")
    private String fechaProyecto;
    @Column(name = "cantidadEstudiantes")
    private Integer cantidadEstudiantes;
     @Column(name = "cantidadGrupos")
    private Integer cantidadGrupos;
    @Column(name = "descripcionProyecto")
    private String descripcionProyecto;
    @JoinColumn(name = "noIdentificacion", referencedColumnName = "noIdentificacion")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario noIdentificacion;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Integer getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(Integer estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public String getFechaProyecto() {
        return fechaProyecto;
    }

    public void setFechaProyecto(String fechaProyecto) {
        this.fechaProyecto = fechaProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public Usuario getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(Usuario noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public Integer getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(Integer cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public Integer getCantidadGrupos() {
        return cantidadGrupos;
    }

    public void setCantidadGrupos(Integer cantidadGrupos) {
        this.cantidadGrupos = cantidadGrupos;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "idProyecto=" + idProyecto + ", nombreProyecto=" + nombreProyecto + ", estadoProyecto=" + estadoProyecto + ", fechaProyecto=" + fechaProyecto + ", cantidadEstudiantes=" + cantidadEstudiantes + ", cantidadGrupos=" + cantidadGrupos + ", descripcionProyecto=" + descripcionProyecto + ", noIdentificacion=" + noIdentificacion + '}';
    }

    

    
    
}

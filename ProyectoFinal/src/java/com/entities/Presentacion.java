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
 * @author Ludy Lozano
 */
@Entity
@Table(name = "presentaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presentacion.findAll", query = "SELECT p FROM Presentacion p")
    , @NamedQuery(name = "Presentacion.findByIdPresentacion", query = "SELECT p FROM Presentacion p WHERE p.idPresentacion = :idPresentacion")
    , @NamedQuery(name = "Presentacion.findByNombrePresentacion", query = "SELECT p FROM Presentacion p WHERE p.nombrePresentacion = :nombrePresentacion")
    , @NamedQuery(name = "Presentacion.findByFechaPresentacion", query = "SELECT p FROM Presentacion p WHERE p.fechaPresentacion = :fechaPresentacion")
    , @NamedQuery(name = "Presentacion.findByDescripcionPresentacion", query = "SELECT p FROM Presentacion p WHERE p.descripcionPresentacion = :descripcionPresentacion")
    , @NamedQuery(name = "Presentacion.findByEstadoPresentacion", query = "SELECT p FROM Presentacion p WHERE p.estadoPresentacion = :estadoPresentacion")})
public class Presentacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPresentacion")
    private Integer idPresentacion;
    @Basic(optional = false)
    @Column(name = "nombrePresentacion")
    private String nombrePresentacion;
    @Column(name = "fechaPresentacion")
    private String fechaPresentacion;
    @Column(name = "descripcionPresentacion")
    private String descripcionPresentacion;
    @Column(name = "estadoPresentacion")
    private Integer estadoPresentacion;
    @Column(name = "nota")
    private Integer nota;
    @Column(name = "cantidadEstudiantes")
    private Integer cantidadEstudiantes;
    @JoinColumn(name = "noIdentificacion", referencedColumnName = "noIdentificacion")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario noIdentificacion;

    public Presentacion() {
    }

    public Presentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public Integer getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getNombrePresentacion() {
        return nombrePresentacion;
    }

    public void setNombrePresentacion(String nombrePresentacion) {
        this.nombrePresentacion = nombrePresentacion;
    }

    public String getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(String fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public String getDescripcionPresentacion() {
        return descripcionPresentacion;
    }

    public void setDescripcionPresentacion(String descripcionPresentacion) {
        this.descripcionPresentacion = descripcionPresentacion;
    }

    public Integer getEstadoPresentacion() {
        return estadoPresentacion;
    }

    public void setEstadoPresentacion(Integer estadoPresentacion) {
        this.estadoPresentacion = estadoPresentacion;
    }

    public Usuario getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(Usuario noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(Integer cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresentacion != null ? idPresentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presentacion)) {
            return false;
        }
        Presentacion other = (Presentacion) object;
        if ((this.idPresentacion == null && other.idPresentacion != null) || (this.idPresentacion != null && !this.idPresentacion.equals(other.idPresentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Presentacion{" + "idPresentacion=" + idPresentacion + ", nombrePresentacion=" + nombrePresentacion + ", fechaPresentacion=" + fechaPresentacion + ", descripcionPresentacion=" + descripcionPresentacion + ", estadoPresentacion=" + estadoPresentacion + ", nota=" + nota + ", cantidadEstudiantes=" + cantidadEstudiantes + ", noIdentificacion=" + noIdentificacion + '}';
    }

    

    
    
}

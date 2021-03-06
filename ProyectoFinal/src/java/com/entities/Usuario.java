package com.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByNoIdentificacion", query = "SELECT u FROM Usuario u WHERE u.noIdentificacion = :noIdentificacion")
    , @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuario.findByCorreoElectronico", query = "SELECT u FROM Usuario u WHERE u.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion")
    , @NamedQuery(name = "Usuario.findLogin", query = "SELECT u FROM Usuario u WHERE u.noIdentificacion = :noIdentificacion AND u.contrasena = :contraseña")
    , @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "noIdentificacion")
    private Long noIdentificacion;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "correoElectronico")
    private String correoElectronico;
    @Column(name = "correoElectronicoInstitucional")
    private String correoElectronicoInstitucional;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "telefono")
    private String telefono;
    
    @JoinTable(name = "usuarioswithroles", joinColumns = {
        @JoinColumn(name = "noIdentificacion", referencedColumnName = "noIdentificacion")}, inverseJoinColumns = {
        @JoinColumn(name = "idRol", referencedColumnName = "idRol")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Rol> roles;
    
    @ManyToMany(mappedBy = "usuarios", fetch = FetchType.LAZY)
    private List<Grupo> grupos;
    
    
    
    @JoinTable(name = "usuarioswithpresentaciones", joinColumns = {
        @JoinColumn(name = "noIdentificacion", referencedColumnName = "noIdentificacion")}, inverseJoinColumns = {
        @JoinColumn(name = "idPresentacion", referencedColumnName = "idPresentacion")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Presentacion> presentaciones;
    
    @JoinTable(name = "usuarioswithproyectos", joinColumns = {
        @JoinColumn(name = "noIdentificacion", referencedColumnName = "noIdentificacion")}, inverseJoinColumns = {
        @JoinColumn(name = "idProyecto", referencedColumnName = "idProyecto")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Proyecto> proyectos;
    
    @JoinColumn(name = "tipoIdentificacion", referencedColumnName = "idTipoIdentificacion")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoIdentificacion tipoIdentificacion;

    public Usuario() {
    }

    public Usuario(Long noIdentificacion, String contrasena, String correoElectronico, String correoElectronicoInstitucional, String nombre, String apellido, String direccion, String telefono, TipoIdentificacion tipoIdentificacion) {
        this.noIdentificacion = noIdentificacion;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Usuario(Long noIdentificacion, String contrasena, String correoElectronico, String correoElectronicoInstitucional, String nombre, String apellido, String direccion, Integer estado, String telefono, List<Rol> roles, List<Presentacion> presentaciones, List<Proyecto> proyectos, TipoIdentificacion tipoIdentificacion) {
        this.noIdentificacion = noIdentificacion;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.estado = estado;
        this.telefono = telefono;
        this.roles = roles;
        this.presentaciones = presentaciones;
        this.proyectos = proyectos;
        this.tipoIdentificacion = tipoIdentificacion;
    }

    
    
    public Usuario(Long noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public Long getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(Long noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getCorreoElectronicoInstitucional() {
        return correoElectronicoInstitucional;
    }

    public void setCorreoElectronicoInstitucional(String correoElectronicoInstitucional) {
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
    @XmlTransient
    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @XmlTransient
    public List<Presentacion> getPresentaciones() {
        return presentaciones;
    }

    public void setPresentaciones(List<Presentacion> presentaciones) {
        this.presentaciones = presentaciones;
    }

    @XmlTransient
    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    @XmlTransient
    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noIdentificacion != null ? noIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.noIdentificacion == null && other.noIdentificacion != null) || (this.noIdentificacion != null && !this.noIdentificacion.equals(other.noIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "noIdentificacion=" + noIdentificacion + ", contrasena=" + contrasena + ", correoElectronico=" + correoElectronico + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", estado=" + estado + ", roles=" + roles + ", presentaciones=" + presentaciones + ", proyectos=" + proyectos + ", tipoIdentificacion=" + tipoIdentificacion + '}';
    }

    
    
}

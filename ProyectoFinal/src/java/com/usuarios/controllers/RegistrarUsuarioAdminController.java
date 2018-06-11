package com.usuarios.controllers;

import com.DAO.RolFacadeLocal;
import com.DAO.UsuarioFacadeLocal;
import com.entities.Rol;
import com.entities.Usuario;
import com.util.MessageUtil;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@Named(value = "registrarUsuarioAdminController")
@RequestScoped
public class RegistrarUsuarioAdminController {
    
    @EJB
    private UsuarioFacadeLocal ufl;
    
    @Inject
    private ListarUsuariosController luc;
    
    @EJB
    private RolFacadeLocal rfl;
    
    private Usuario usuarioNuevo;    
    private String estadoString;
    private String rolString;
    
    public RegistrarUsuarioAdminController() {
    }
    
    @PostConstruct
    public void init(){
        usuarioNuevo = new Usuario(); 
        luc.listarUsuarios();
   }

    public Usuario getUsuarioNuevo() {
        return usuarioNuevo;
    }

    public void setUsuarioNuevo(Usuario usuarioNuevo) {
        this.usuarioNuevo = usuarioNuevo;
    }

    public String getEstadoString() {
        return estadoString;
    }

    public void setEstadoString(String estadoString) {
        this.estadoString = estadoString;
    }

    public String getRolString() {
        return rolString;
    }

    public void setRolString(String rolString) {
        this.rolString = rolString;
    }
    
    public void registrarUsuario(){
        if (usuarioNuevo != null) {
            if (getEstadoString().equalsIgnoreCase("Activo")) {
                usuarioNuevo.setEstado(1);
            }else if (getEstadoString().equalsIgnoreCase("Bloqueado")) {
                usuarioNuevo.setEstado(2);
            }
            
            if (getRolString().equalsIgnoreCase("Administrador")) {
                usuarioNuevo.setRoles(new ArrayList<Rol>());
                usuarioNuevo.getRoles().add(rfl.find(1));
            }else if(getRolString().equalsIgnoreCase("Profesor")){
                usuarioNuevo.setRoles(new ArrayList<Rol>());
                usuarioNuevo.getRoles().add(rfl.find(2));
            }else if(getRolString().equalsIgnoreCase("Estudiante")){
                usuarioNuevo.setRoles(new ArrayList<Rol>());
                usuarioNuevo.getRoles().add(rfl.find(3));
            }
            ufl.create(usuarioNuevo);
            MessageUtil.enviarMensajeInformacion("form-crear-admin", "Registro exitoso!", "El usuario se ha registrado correctamente");
            init();
        }
        else
        {
            MessageUtil.enviarMensajeError("form-crear-admin", "Error", "No se han diligenciado datos");
        }
    }
    
    
    
}

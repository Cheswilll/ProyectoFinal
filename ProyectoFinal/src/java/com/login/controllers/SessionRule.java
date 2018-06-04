package com.login.controllers;


import com.DAO.UsuarioFacadeLocal;
import com.entities.Rol;
import com.entities.Usuario;
import com.util.MessageUtil;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SessionRule {
    
    @EJB
    private UsuarioFacadeLocal ufl;

    public Usuario iniciar(Long noidentificacion, String contraseña) {
        Usuario u = null;
        if (noidentificacion != null && noidentificacion > 0
                && contraseña != null && contraseña.length() > 0) {
            u = ufl.login(noidentificacion, contraseña);
            if (u != null) {
                if (u.getEstado() == 2) {
                    u = null;
                    MessageUtil.enviarMensajeErrorGlobal(
                            "Usuario bloqueado",
                            "Contacte al administrador par que solucione el incoveniente.");

                }
            } else {
                MessageUtil.enviarMensajeErrorGlobal(
                        "Datos incorrectos",
                        "Documento y/o clave invalidos");
            }
        } else {
            MessageUtil.enviarMensajeErrorGlobal(
                    "Datos obligatorios",
                    "Documento y/o clave son necesarios para iniciar sesión");
        }
        return u;
    }

    public Rol validarRol(Usuario u) {
        Rol r = null;
        if (u.getRoles() != null && u.getRoles().size() > 0) {
            r = u.getRoles().get(0);
        } else {
            MessageUtil.enviarMensajeErrorGlobal(
                    "Rol no asignado",
                    "Debe esperar a que se le asigne un rol dentro del sistema");
        }
        return r;
    }
}
